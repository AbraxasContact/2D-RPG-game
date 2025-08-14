# 🎮 Contributing to 2D-RPG-Game

<div align="center">

**First off, thank you for your interest in contributing!**  
*We welcome contributions from everyone, whether it's fixing a bug, adding new features, or improving documentation.*

---

</div>

## 📋 Table of Contents

- [🚀 Getting Started](#-getting-started)
- [💻 Project Setup](#-project-setup)
- [✏️ Making Changes](#️-making-changes)
- [📤 Pull Request Guidelines](#-pull-request-guidelines)
- [🎨 Code Style](#-code-style)
- [🐛 Reporting Issues](#-reporting-issues)

---

## 🚀 Getting Started

### Step 1: Fork & Clone
1. **Fork the repository** to your own GitHub account
2. **Clone your fork** to your local machine:
   ```bash
   git clone https://github.com/AbraxasContact/2D-RPG-game.git
   ```

### Step 2: Set Up Upstream
3. **Add the original repo** as upstream:
   ```bash
   git remote add upstream https://github.com/AbraxasContact/2D-RPG-game.git
   ```

---

## 💻 Project Setup

### Prerequisites
Make sure you have the following installed:

| Requirement | Description |
|-------------|-------------|
| ☕ **Java 17+** | Or the version specified in the project |
| 🛠️ **Java IDE** | IntelliJ IDEA, Eclipse, or VS Code with Java extension |
| 📁 **Git** | Version control system |

### Build & Run
```bash
# Compile the project
javac Main.java

# Run the game
java Main
```

> 💡 **Tip:** Make sure the project builds successfully before making any changes!

---

## ✏️ Making Changes

### 1. Create a Feature Branch
```bash
git checkout -b feature/your-feature-name
```

### 2. Make Your Changes
- Write clean, well-documented code
- Test your changes thoroughly
- Follow the project's coding standards

### 3. Commit Your Changes
```bash
git add .
git commit -m "Add: brief description of change"
```

### 4. Push to Your Fork
```bash
git push origin feature/your-feature-name
```

---

## 📤 Pull Request Guidelines

### Before Submitting
- [ ] **Keep PRs focused** — one feature or fix per PR
- [ ] **Reference related issues** in your PR description (e.g., `Fixes #12`)
- [ ] **Ensure the project builds** without errors before submitting
- [ ] **Test your changes** thoroughly

### PR Template
When creating a pull request, please include:

```markdown
## Description
Brief description of changes

## Type of Change
- [ ] Bug fix
- [ ] New feature
- [ ] Documentation update
- [ ] Performance improvement

## Testing
- [ ] Tested locally
- [ ] No breaking changes

## Related Issues
Closes #(issue number)
```

### Code Review Etiquette
- Be respectful and constructive in code reviews
- Respond promptly to feedback
- Ask questions if something is unclear

---

## 🎨 Code Style

### Java Conventions
- ✅ Follow **Java naming conventions**
- ✅ Keep **methods small and focused**
- ✅ Use **meaningful variable names**
- ✅ **Comment code** where needed, but keep it clear and concise

### Commit Messages
Use descriptive commit messages with prefixes:

| Prefix | Usage | Example |
|--------|-------|---------|
| `Add:` | New features or files | `Add: player inventory system` |
| `Fix:` | Bug fixes | `Fix: collision detection issue` |
| `Update:` | Modifications to existing code | `Update: improve rendering performance` |
| `Remove:` | Deleted code or files | `Remove: unused utility functions` |
| `Refactor:` | Code restructuring | `Refactor: simplify game loop logic` |

---

## 🐛 Reporting Issues

Found a bug? Help us fix it!

### Before Reporting
1. **Check existing issues** in the [Issues tab](https://github.com/AbraxasContact/2D-RPG-game/issues)
2. **Search for similar problems** to avoid duplicates

### Creating a Bug Report
If the issue doesn't exist, create a new one with:

#### 🔍 **Steps to Reproduce**
```
1. Go to '...'
2. Click on '...'
3. Scroll down to '...'
4. See error
```

#### ❌ **Expected vs Actual Behavior**
- **Expected:** What should happen
- **Actual:** What actually happened

#### 📎 **Additional Information**
- Screenshots or error logs (if applicable)
- Operating system and Java version
- Any relevant configuration details

---

<div align="center">

## 🎉 Happy Coding! 🎮

*Thank you for contributing to the 2D-RPG-Game project!*

**The 2D-RPG-Game Maintainers**

---

*For questions or additional help, feel free to reach out in the AbraxasContact.*

</div>