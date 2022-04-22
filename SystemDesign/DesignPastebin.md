# Design Pastebin

# Requirements

Our Pastebin service should meet the following requirements:

**Functional Requirements:**

1. Users should be able to upload or “paste” their data and get a unique URL to access it.
2. Users will only be able to upload text.
3. Data and links will expire after a specific timespan automatically; users should also be able to specify expiration time.
4. Users should optionally be able to pick a custom alias for their paste.

**Non-Functional Requirements:**

1. The system should be highly reliable, any data uploaded should not be lost.
2. The system should be highly available. This is required because if our service is down, users will not be able to access their Pastes.
3. Users should be able to access their Pastes in real-time with minimum latency.
4. Paste links should not be guessable (not predictable).

**Extended Requirements:**

1. Analytics, e.g., how many times a paste was accessed?
2. Our service should also be accessible through REST APIs by other services.

## Design Considerations

- size of uploads
    - 10MB
- limits on custom url
    - yes
    

## Estimates

- read heavy 5:1 read to writes

### Traffic

- 1 millions new records a day
    - 1M / 24 hours / 60 mins / 60 seconds = 12 writes a second
- 5 million records a day
    - 60 reads a second

### Storage

- assume the average paste is 10 KB
- 10 KB * 1M = 10 GB / day
- 5 years of storage
    - 10GB * 365 * 5 = 18250 GB or 18 TB
- 5 years of items
    - 1M * 365 * 5 =  1.8 billion records
- ID’s
    - base64 encoding
    - 6 characters
    - 64^6 = 68.7 billion strings
- key size
    - 1 byte per chart
    - 1.8N records * 6 bytes = 11 GB
- we can use 70% model
- dont use more than 70% of storage
    - 18 TB / .7 = 25 TB needed

### Network

- reads
    - 12 pastes per second
    - 10KB avg size
        - 12 * 10KB = 120 KB per second
- writes
    - 58 writes per second
    - 10 KB avg size
        - 58 * 10KB = 580 KB per second

### Memory

- caching
- 20% rule
    - 5 million reads
    - 20% rules
        - 10 KB avg size
        - 5M * .2 * 10KB = 10GB
        

## API

- AddPaste
    - input
        - dev key or token
        - past data
        - alias - optional
        - usename - optional
        - pastename - optional
        - exp date
    - output
        - string for url
- GetPaste
    - intput
        - dev key or token
        - pk string for item
    - output
        - data for paste
- DeletePaste
    - input
        - same as get
    - output
        - boolean if delete is successful

## Database

- need to store BILLIONS of records
- small meta data items
    - if too big cant use dynamo without extra costs
- very few relationships

### High Level Design

- client
    - cloud front
- app server
    - ECS or Lambda
- meta storage
    - DDB
- object storage
    - S3

## Component Design

### App Layer

- generate unique id, if the user has not provided one
- store the contents of the paste + key
- return key to use
- key generation problem
    - avoid collisions and dupes
    - abstract to a key gen service
    - two tables, avail and used