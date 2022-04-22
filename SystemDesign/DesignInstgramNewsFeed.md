# Design Instagram Newsfeed

We’ll focus on the following set of requirements while designing Instagram:

**Functional Requirements**

1. Users should be able to upload/download/view photos.
2. Users can perform searches based on photo/video titles.
3. Users can follow other users.
4. The system should generate and display a user’s News Feed consisting of top photos from all the people the user follows

**Non-functional Requirements**

1. Our service needs to be highly available.
2. The acceptable latency of the system is 200ms for News Feed generation.
3. Consistency can take a hit (in the interest of availability) if a user doesn’t see a photo for a while; it should be fine.
4. The system should be highly reliable; any uploaded photo or video should never be lost.

**Not in scope:** Adding tags to photos, searching photos on tags, commenting on photos, tagging users to photos, who to follow, etc.

### Estimates

- 500M users
- 1M daily active users
- 2M be photos a day
- 23 new photos a second
- Total space for photos / day
    - 2M * 200KB = ~400GB
- 10 years
    - 400 * 365 * 10 = 1425 TB!!
    

## High level design

- need an object store for photos
- need another db to track photo meta

## High level DB design

- Photo (for meta)
    - user_id
    - photo_path
    - lat
    - long
    - user_lat
    - user_long
    - audit fields
- user
    - user_id
    - name
    - email
    - dob
    - audit_fields
- user_follower
    - from_user
    - to_user

## DB Size Estimate

### user table

- assume int and date_time is 4 bytes users will need ~68 bytes per row
    - user_id (4)
    - name (20)
    - email (32)
    - dob(4)
    - create_date (4)
    - last_login (4)
    - total = 68 bytes
    
    500 millions users
    
    - 500M * 68 bytes = 32GB
    
    ### photo table
    
    - photo_id (4)
    - user_id (4)
    - photopath (256)
    - lat (4)
    - long (4)
    - user_lat (4)
    - user_long (4
    - create_date(4)
    - total 284 bytes
    
    2M photos a day = 
    
    2M * 284 = 0.5GB per day
    
    10 years = 1.88 TB
    
    ### user follow
    
    - each row is only 8 bytes
    - 500M users
    - avg 500 followers
    
    500M * 500 followers * 8 bytes = 1.82 TB
    
    32GB + 1.88TB + 1.82TB = 3.7TB
    

## Component Design

- web servers typically have connection limits (say 500 connections)
- writes in this app will consume a lot of conenctions
- but there will be a lot of reads
- it may make sense to break read and write into different services

## Reliability and Redundancy

- cannot lose files
- replicate object store for images
- make services highly available

## Data Sharding

- partition based on user id
- partition based on photo id

## Ranking and Newsfeed generation

- need to fetch top 100 photos for a user news feed
- process
    - user makes request
    - get list of people the users follows
    - fetch meta data info for each users latest 100 photos
    - user a ranking algo to determine the top 100 total
- pregenerate newsfeed
    - has a table and service that is dedicated to continounsly generating news feeds
- how to users get new feed content?
    - pull
        - clients pull when they need data
        - this may result in a lot of empty responses if there is no new data
    - push
        - servers push as soon as it available
        - this can be a problem with users who follow a lot of users
        - or users with a lot of followers
    - hybrid
        - pull for large accounts
        - push for small
        

## News Feed Creation with Sharding

- we need a way to quickly get the top 100 most recent images for a user
- can do this by making a creation_time + photo_id primary key

## Cache and LB

- use a CDN for photos
- use something like Memcache to cache meta data for hot rows