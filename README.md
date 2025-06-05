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
