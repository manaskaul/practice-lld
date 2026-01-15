# Low-Level Design Practice

Object-oriented design implementations and system design projects in Java.

## 🏗️ Projects

### 00. Design Patterns (`lld_00_patterns/`)
Common design pattern implementations and examples.
- Creational Patterns
- Structural Patterns
- Behavioral Patterns

### 01. Parking Lot (`lld_01_parking_lot/`)
Multi-level parking management system.
- Vehicle types and parking spot assignment
- Fee calculation
- Entry/exit management

### 02. Elevator System (`lld_02_elevator/`)
Complete elevator control system design.
- Multiple elevator coordination
- Request scheduling algorithms
- Floor management

### 03. Tic Tac Toe (`lld_03_tic_tac_toe/`)
A flexible, well-designed Tic Tac Toe game implementation.

**Design Patterns:**
- Strategy Pattern for move generation and win detection
- Interface segregation for player types
- Dependency injection for flexibility

**Features:**
- Multiple player types (Human, Bot)
- Pluggable move strategies
- Pluggable win condition strategies
- Clean OOP design with SOLID principles

**Documentation:**
- [UML Class Diagram](lld_03_tic_tac_toe/uml_class_diagram.md)

### 04. ZoomCar (`lld_04_zoomcar/`)
Car rental system design.
- Vehicle booking and management
- User reservations
- Pricing and availability

## 🎯 Design Principles

All projects follow **SOLID Principles:**
- **S**ingle Responsibility
- **O**pen/Closed
- **L**iskov Substitution
- **I**nterface Segregation
- **D**ependency Inversion

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code)

### Running Projects

```bash
cd lld_XX_project_name
javac Main.java
java package_name.Main
```

Example:
```bash
cd lld_03_tic_tac_toe
javac Main.java
java tic_tac_toe.Main
```

## 📚 Project Structure

Each project includes:
- ✅ Clean class design
- ✅ UML diagrams (where applicable)
- ✅ Design documentation
- ✅ Well-commented code
- ✅ Runnable examples

## 🛠️ Utility Commands

### Generate Code Documentation
```bash
find . -type f -name "*.java" -exec sh -c '
  echo "===== FILE: {} =====";
  cat "{}";
  echo;
' \; > repomix.txt
```

## 📝 Notes

- Solutions prioritize clean design and maintainability
- Each project demonstrates real-world system design scenarios
- Code follows Java naming conventions and best practices

---

*Last Updated: January 2026*