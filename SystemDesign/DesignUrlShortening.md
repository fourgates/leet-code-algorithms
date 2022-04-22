# Design URL Shortening

# Traffic

### Given

- 500M new urls / month
- a lot of reads vs write, 100:1

This means that there will be 500M * 100 reads per month

- 50 Billion Reads!
- 500M Writes

## How many writes per second?

- 500M / (30 * 24 *3600) = ~200 URL created per second
- 200 * 60 = 12,000 per min

## How many reads per second?

- 200 * 100 = 20,000 reads per second
- 20,000 * 60 = 1,200,000 reads per min

## Storage

- over 5 years?
    - 500M * 12 * 5 = 30 billion records
- size?
    - 30 billion * 500 bytes (estimated) = 15,000 Billion Bytes = 15 TB

## Bandwidth

- 200 urls writes a second
    - 200 * 500 bytes = 100000 bytes / second = 100 KB
- 20,000 reads a second
    - 20000 * 500 bytes = 10,000,000 = 10 MB/s

## Caching

- 80-20 rule we should cache 20% of the urls
- calc the total requests per day
- multiple by the avg size of a read
- take 20% of that
    - 20K (read per second) * 3600 * 24 = 1.7B = requests per day
    - 1.7B * 500KB * .2 = 170GB = total size of requests per day
    - (this is a ceiling estimate)
    

## API

- make url
    - input
        - token or dev ley
        - old url
        - subdomain
        - exp
        - username
    - output
        - string url if success
        - error error response or exception otherwise
- delete url
    - token or dev key
    - shortened url
- how to you prevent abuse
    - throttle using token or dev key