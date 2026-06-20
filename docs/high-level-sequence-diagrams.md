# High Level Sequence Diagrams

## Investigation Lifecycle

### User Flow (Request Path)


User

↓

POST /api/investigations

↓

Investigation Controller

↓

Investigation Service

↓

Create Investigation Record

status = CREATED

↓

Persist Investigation

↓

Publish InvestigationCreated Event

↓

Return Investigation ID

---


### Background Worker Flow (Async Processing)

Background Worker

↓

Consume InvestigationCreated Event

↓

Update Status = COLLECTING_EVIDENCE

↓

Execute Log Collector

↓

Execute Metric Collector

↓

Execute Deployment Collector

↓

Execute Kafka Collector

↓

Generate Evidence Bundle

↓

Update Status = ANALYZING

↓

Generate Incident Timeline

↓

Execute AI Root Cause Analysis

↓

Persist Investigation Report

↓

Update Status = COMPLETED

---


### User Flow (Result Retrieval)

User

↓

GET /api/investigations/{id}

↓

Receive Investigation Status

or

Receive Final Investigation Report

-----
## Status Transitions

`CREATED` → `COLLECTING_EVIDENCE` → `ANALYZING` → `COMPLETED`