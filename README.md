Here is a production-ready, clean, and comprehensive `README.md` designed specifically for your **`SpringAIExplore`** repository.

You can copy and paste the markdown block directly into the `README.md` file at the root of your repository.

---

[![Java](https://img.shields.io/badge/Java-17%20%7C%2021-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3%2B-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/projects/spring-boot)
[![Spring AI](https://img.shields.io/badge/Spring%20AI-1.0.0%2B-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/projects/spring-ai)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg?style=for-the-badge)](LICENSE)

```markdown


A hands-on, production-grade exploration and architectural showcase for enterprise AI application development using **Spring AI**, **Spring Boot 3**, and modern Generative AI design patterns.

This repository demonstrates practical implementations for Large Language Models (LLMs), Retrieval-Augmented Generation (RAG), Function Calling / Agentic Tool Integration, Vector Databases, Structured Output Parsing, Prompt Engineering, and Local Model execution (Ollama).

---

## 📌 Core Features & Modules

### 1. 🤖 LLM Integrations & Multi-Model Abstraction
- **Cloud LLMs (OpenAI):** Sync and asynchronous streaming responses using `Flux<String>` with models like `gpt-4o` and `gpt-3.5-turbo`.
- **Local Models (Ollama):** Run open-source LLMs locally (`Llama 3`, `Mistral`, `Phi-3`) without external cloud dependencies.
- **Portable Abstractions:** Seamless switching between model providers via Spring AI's unified `ChatModel` and `EmbeddingModel` interfaces.

### 2. 📚 Retrieval-Augmented Generation (RAG)
- **ETL Data Pipelines:** Ingesting and processing unstructured data (PDFs, JSON, Markdown, Text) using `DocumentReader` and `TextSplitter`.
- **Vector Database Integration:** High-performance vector embeddings storage using **PGVector** (PostgreSQL), **ChromaDB**, or **Pinecone**.
- **Semantic Search:** Question-Answering over custom knowledge bases using cosine similarity and configurable similarity thresholds.

### 3. 🛠️ Function Calling & Agentic Capabilities
- **Dynamic Tool Execution:** Exposing Java `@Bean` functions as dynamic tools reachable by the LLM.
- **Real-Time Data Integration:** Allowing models to trigger internal backend services, live REST endpoints, or database lookups dynamically.

### 4. 🧩 Structured Output Parsing
- **BeanOutputConverter:** Automatically converting unstructured LLM outputs into strongly typed Java DTOs, Records, or JSON Schemas.
- **List & Map Converters:** Enforcing structured JSON responses for downstream service consumption.

### 5. 💬 Conversation State & Memory Management
- Multi-turn conversational memory management using `ChatMemory`, Spring AI `Advisor` chains, and persistent storage strategies.

---

## 🛠️ Technology Stack

| Component | Technology / Library |
|---|---|
| **JDK & Framework** | Java 17 / 21, Spring Boot 3.3.x, Spring WebFlux |
| **AI Integration** | Spring AI Framework (`1.0.0-M1` / `0.8.x`) |
| **Model Providers** | OpenAI API, Ollama (Local Execution) |
| **Vector DB / Store** | PGVector (PostgreSQL Vector Extension) / ChromaDB |
| **Build & Containers** | Apache Maven, Docker / Docker Compose |

---

## 📁 Repository Structure


SpringAIExplore/
├── docker/
│   ├── docker-compose.yml          # PostgreSQL + PGVector & Ollama containers
│   └── init.sql                    # Database vector extensions setup
├── src/
│   ├── main/
│   │   ├── java/com/example/springai/
│   │   │   ├── config/             # VectorStore, ChatClient, and Model Beans setup
│   │   │   ├── controller/         # REST APIs for Chat, RAG, and Agent Tools
│   │   │   ├── domain/             # Strongly typed Records / DTOs for structured output
│   │   │   ├── functions/          # Spring @Bean Tools / Functions for LLM Agentic workflow
│   │   │   ├── service/            # Core AI orchestrators, ingestion pipelines, & RAG logic
│   │   │   └── SpringAiApplication.java
│   │   └── resources/
│   │       ├── application.yml     # Enterprise configurations & model profiles
│   │       ├── documents/          # Knowledge base docs for ingestion
│   │       └── prompts/            # External prompt templates (.st files)
├── pom.xml
└── README.md

## ⚙️ Prerequisites

1. **Java Development Kit (JDK 17 or 21)**
2. **Apache Maven 3.8+**
3. **Docker & Docker Desktop** (for local vector database and Ollama containers)
4. **OpenAI API Key** *(Optional if executing exclusively via Ollama)*

---

## 🚀 Getting Started

### 1. Clone the Repository
```bash
git clone [https://github.com/YellaiahMekala/SpringAIExplore.git](https://github.com/YellaiahMekala/SpringAIExplore.git)
cd SpringAIExplore

```

### 2. Start Infrastructure Services

Spin up PostgreSQL with `pgvector` support and local `Ollama` containers:

```bash
docker-compose -f docker/docker-compose.yml up -d

```

### 3. Set Up Environment Variables

Export your API key before launching the application:

```bash
# On Linux/macOS
export OPENAI_API_KEY="your-actual-openai-api-key"

# On Windows (PowerShell)
$env:OPENAI_API_KEY="your-actual-openai-api-key"

```

### 4. Build and Run the Application

```bash
mvn clean package -DskipTests
mvn spring-boot:run

```

The application will launch on **`http://localhost:8080`**.

---

## 🧪 Key Endpoints & Usage Examples

### 1. Direct LLM Chat Completion

**POST** `/api/v1/ai/chat`

```bash
curl -X POST http://localhost:8080/api/v1/ai/chat \
  -H "Content-Type: application/json" \
  -d '{"message": "Explain RAG architecture in Spring AI with 3 bullet points."}'

```

### 2. Reactive Streaming Chat (`Server-Sent Events`)

**GET** `/api/v1/ai/stream?message=Write a Java method for binary search.`

### 3. RAG - Ingest Documents to Vector Store

**POST** `/api/v1/ai/rag/ingest`

```bash
curl -X POST http://localhost:8080/api/v1/ai/rag/ingest

```

### 4. RAG - Semantic Search over Ingested Context

**POST** `/api/v1/ai/rag/ask`

```bash
curl -X POST http://localhost:8080/api/v1/ai/rag/ask \
  -H "Content-Type: application/json" \
  -d '{"question": "What are the key terms in our policy document?"}'

```

### 5. Function Calling / Agentic Tool Execution

**GET** `/api/v1/ai/tools/weather?city=Seattle`

---

## ⚙️ Sample Configuration (`application.yml`)

```yaml
spring:
  application:
    name: spring-ai-explore

  ai:
    openai:
      api-key: ${OPENAI_API_KEY}
      chat:
        options:
          model: gpt-4o
          temperature: 0.7
    ollama:
      base-url: http://localhost:11434
      chat:
        options:
          model: llama3
    vectorstore:
      pgvector:
        index-type: HNSW
        distance-type: COSINE
        dimensions: 1536

  datasource:
    url: jdbc:postgresql://localhost:5432/springai_db
    username: postgres
    password: postgrespassword

```

---

## 📄 License

This project is open-source and available under the [MIT License](https://www.google.com/search?q=LICENSE).

---

## 👨‍💻 Author

**Yellaiah Mekala**

*Java Full-Stack & AI Backend Integration Engineer & Gen AI Platform Engineer* 

* **GitHub:** [@YellaiahMekala](https://www.google.com/search?q=https://github.com/YellaiahMekala)
* **LinkedIn:** [@YellaiahMekala](https://www.google.com/search?q=https://www.linkedin.com/in/yellaiah-mekala/)


```

```
