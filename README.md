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

### How It Works

- Find a path from source to sink with available capacity (residual capacity > 0).
- Find the minimum capacity on that path (bottleneck).
- Add this bottleneck to the flow and update both forward and backward (residual) edges.
- Repeat until no augmenting path exists.

### 🔧 Technologies Used

- Java – Core programming language
- OOP – Clean separation of concerns across models, algorithms, and parsers
- File I/O – For reading custom input networks
- Graph Theory – Directed graph and residual graph logic
- Collections – Java Lists, Queues for graph traversal

### 🎓 Educational Value

- This project is ideal for:
- Learning graph algorithms
- Understanding flow networks and residual graphs
- Exploring real-world applications like network routing, traffic flow, or job assignment problems
