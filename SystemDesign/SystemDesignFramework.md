# System Design System

## Step 1 - Requirements clarifications

- System design Q’s dont have one correct answer. it is very important to clarify ambigutites early in the interview to be successful.
- define the end goals of the system
- examples
    - identify all the actions a user can perform
    - confirm any assumptions
    - Is there any constraint on media?
        - photos
        - video
    - Full Stack? BE? FE?
    - Searching and/or Aggregation?
    - DB Constrains?
    - How will this component communication with others
        - notifications
        - event driven components
    - on prem? cloud?
    - define functional vs non function requirements
        - functional
            - users can do x, y, and z
            - constrains or side effects of actions
        - non functional
            - attributes of the system
                - highly available
                - reliability
                - latency
                - security

## Step 2: Back of the envelop estimation

- you should estimate the scale of the system
    - users
    - data
    - how much and what kind of storage
    - network bandwidth and latency requirements
    - regular traffic? seasonal?
    - pricing constraints
    - budget for consultants

## Step 3: System interface def

- define what API’s are expected
- this establishes the contract expected from the system and will help verify requirements

## Step 4: Defining data model

- this will help define the flow of data between diff system components
- again will help establish requirements have been met
- identify which db would be best

## Step 5: High-level design

- define enough components that are needed to solve the actual problem, end to end

## Step 6: Detailed design

- dig deeper into 2-3 major components
- interviewer should drive where you should spend your time
- examples
    - data partitioning and replication
    - reader / writers
    - hot partitions
    - optimizations for finding frequent data
    - when and where to introduce cache
    - where should better load balancing be required
    

## Step 7: Identify and resolving bottlenecks

- single point of failure?
- replications
- redundancies
- monitoring and alerts

p = grab marker and draw

t = add some text

n = stick a post-it on the board

v = select/drag tool

m = marquee