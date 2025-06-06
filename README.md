# 🔗 Maximum Flow Network Solver

A **Java console application** that calculates the **maximum flow** in a directed flow network using the **Ford-Fulkerson algorithm**. The project features a modular design including custom classes for parsing network data from files, graph construction, and algorithm execution with step-by-step logging.

---

## 📌 Features

- ✅ Computes maximum flow using **Ford-Fulkerson** with **BFS-based augmenting paths**
- 📂 Supports **custom input files** for defining flow networks
- 🧠 **Modular design**: clean separation of parser, model, and algorithm logic
- 📋 Logs each step of **flow augmentation** for visualization or debugging

---

## 📁 File Structure

- FlowNetwork/
- ├── algorithm/
- │ └── FordFulkerson.java
- ├── model/
- │ ├── Graph.java
- │ └── Edge.java
- ├── parser/
- │ └── NetworkParser.java
- ├── resources/
- │ └── ladder_1.txt
- └── Main.java

---

## 📥 Input Format

- The input file defines the flow network:

- <number_of_nodes>
- <from_node> <to_node> <capacity>
- <from_node> <to_node> <capacity>

### 📄 Example (`ladder_1.txt`):

- 4
- 0 1 3
- 0 2 2
- 1 2 5
- 1 3 2
- 2 3 3
  
In this example:
- There are 4 nodes (numbered 0 to 3).
- Node `0` is the source.
- Node `3` is the sink.
- Edges have associated capacities.

---

## 🧪 How to Run the Application

### ✅ Prerequisites

- Java 8 or higher
- IDE like **IntelliJ IDEA**, **Eclipse**, or **NetBeans**
- Alternatively, a command-line JDK
