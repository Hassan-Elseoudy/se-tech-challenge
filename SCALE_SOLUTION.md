# GetYourGuide Coding Challenge

## Problem

The problem is to implement a simple search engine for activities. The user should be able to search for activities by
title. The search results should display the title, price with currency, rating, whether it has a special offer or not,
the activity's supplier name, and their location.

## Solution

### Back of the Envelope Estimation

1. **Number of Activities**: 100,000
2. **Number of suppliers**: 20,000
3. **Number of users**: 8,000,000
4. **Active users per day**: (10% of total users) 800,000
5. **Search Queries per day**: Each user makes 10 search queries per day on average (8,000,000 * 10 = 80,000,000)
6. **Search Queries per second**: 80,000,000 / (24 * 3600) ≈ 925 queries per second
7. **Storage**: Assuming each activity record is 1KB, the total storage required for activities is 100,000 * 1KB =
   100MB.
8. **Traffic**: Assuming each search query response is 1KB, the total traffic generated per day is 80,000,000 * 1KB =
   80GB.
9. **Memory**: Assuming each search query response is cached for 1 hour, the total memory required for caching is 80GB.
10. **Latency**: The search engine should respond within 100ms for a good user experience.
11. **Scalability**: The system should be scalable to handle a 2x increase in traffic in the future.
12. **Availability**: The system should be highly available with at least 99.99% uptime.

### Functional Requirements

1. **Search Activities**: Users should be able to search for activities by title.
2. **Display Activity Details**: The search results should display the title, price with currency, rating, whether it
   has a
   special offer or not, the activity's supplier name, and their location.
3. **Filtering Logic**: The application should implement filtering logic to search for activities based on the title.

### Potential Bottlenecks and Mitigations

1. **High Cache Memory Demand**: With ~80GB of cache storage needed, a Redis cluster with sufficient memory should be
   provisioned. Memory could be optimized by selectively caching only the most frequently queried terms and setting an
   appropriate expiration policy.

2. **Query Performance under Heavy Load**: Regularly monitor query latency via Kibana. Use Elasticsearch query
   optimizations, such as sharding, replica nodes, and index lifecycle management, to reduce query times and manage
   indices efficiently.

3. **API Gateway Overload**:
    * Implement auto-scaling policies for the API Gateway to dynamically handle load surges.
    * Set rate limiting on the API Gateway to protect backend instances from unexpected query spikes.

4. **Storage Capacity Planning**:
   While 100MB of storage is manageable, the system should be designed to scale beyond this in the future. Implement
   index management and data retention policies in Elasticsearch to control storage growth.

5. Availability and Disaster Recovery:
   For 99.99% availability, deploy across multiple zones and consider a multi-region setup for disaster recovery.
   Use automated failover mechanisms in Redis and Elasticsearch to recover quickly in case of node failures.

#### Search Database Selection

Use Elasticsearch for optimal full-text search performance if we expect high data volume and frequent search queries.
Elasticsearch is designed for search-heavy applications, supports horizontal scaling, and provides efficient querying
for search patterns.

#### Backend Filtering Logic

Implement the filtering logic on the backend using Elasticsearch’s querying capabilities. This will reduce data
transfer, allowing the backend to send only the filtered results to the frontend. Centralized filtering also simplifies
the frontend code.

#### REST API Structure

Opt for a REST API for straightforward access to search endpoints. Each endpoint will be well-defined for specific
actions (e.g., GET /activities?title=...). REST is well-suited for standard querying and works effectively with the
VueJS frontend.

#### Dockerized Setup

Utilize Docker Compose to streamline the development and deployment process. This setup ensures portability and
consistency across environments, allowing the backend, frontend, and Elasticsearch services to run seamlessly with a
single command.
