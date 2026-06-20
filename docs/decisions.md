# Architectural Decisions

## ADR-001: Architecture Style

**Status:** Accepted

**Decision:**
SherlockOps will be implemented as a Modular Monolith.

**Reasoning:**
The project is being developed by a single engineer(myself only) and targets a one-week timeline. A modular monolith provides clear domain boundaries while avoiding the operational overhead of microservices.

**Consequences:**
- Faster development
- Simpler deployment
- Easier local development
- Future extraction into microservices remains possible

---

## ADR-002: Investigation Processing Model

**Status:** Accepted

**Decision:**
Investigations will be processed asynchronously.

**Reasoning:**
Evidence collection and AI analysis are potentially long-running operations. Synchronous request processing would increase latency and reduce scalability.

**Consequences:**
- Investigation creation remains fast
- Long-running work moves to background workers
- Status tracking becomes necessary

---

## ADR-003: Persistence Layer

**Status:** Accepted

**Decision:**
PostgreSQL will be the primary system of record.

**Reasoning:**
Investigation data is highly structured and relational. PostgreSQL provides reliability, transactional guarantees, and strong support within the Spring ecosystem.

**Consequences:**
- Strong consistency
- Mature tooling
- Easy local development

---

## ADR-004: Messaging Platform

**Status:** Accepted

**Decision:**
Kafka will be used for investigation event processing.

**Reasoning:**
The system is event-driven by nature. Kafka enables decoupled background processing and future horizontal scalability.

**Consequences:**
- Event-driven architecture
- Increased operational complexity
- Better extensibility for future collectors

---

## ADR-005: AI Integration

**Status:** Accepted

**Decision:**
LangChain4j will be used as the abstraction layer for LLM interactions.

**Reasoning:**
LangChain4j integrates naturally with Spring Boot and allows model providers to be changed with minimal code changes.

**Consequences:**
- Faster AI integration
- Reduced vendor lock-in
- Additional abstraction layer

---

## ADR-006: Frontend Strategy

**Status:** Accepted

**Decision:**
The initial frontend will be intentionally minimal.

**Reasoning:**
The primary value of SherlockOps is in backend processing, evidence collection, timeline generation, and root cause analysis.

**Consequences:**
- Faster MVP delivery
- More engineering effort focused on core functionality
- Frontend can evolve independently later