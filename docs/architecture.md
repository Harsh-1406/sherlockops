# Architecture

## Core Modules

### Investigation
**Owns:**
- Investigation
- InvestigationStatus

### Collector
**Owns:**
- LogCollector
- MetricCollector
- DeploymentCollector
- KafkaCollector

### Timeline
**Owns:**
- TimelineEvent
- TimelineBuilder

### AI
**Owns:**
- RootCauseAnalyzer
- PromptBuilder

### Knowledge
**Future:**
- Historical incidents
- Similarity search
- RAG