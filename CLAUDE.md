# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## What this is

A Java teaching repository for an OOP course (course code IT01557). Each lesson is a self-contained set of small example programs. There is **no build system** (no Maven/Gradle) and **no test framework** — code is compiled and run directly with `javac`/`java`. Most source comments and console output are in Traditional Chinese.

## Layout

`phase01basic/oop/lessonNN/` — one directory per lesson. A lesson typically contains several standalone classes plus, in some lessons, a `Runner.java` whose `main` drives the other classes. Some lessons include a `doc.md` / `doc.txt` with teaching notes.

## Compile and run

Every file declares a `package` matching its directory (`phase01basic.oop.lessonNN`). Always compile and run from the **project root** using the fully-qualified class name:
```console
javac phase01basic/oop/lesson06/Runner.java
java -cp . phase01basic.oop.lesson06.Runner
```

`javac` compiles classes referenced by the file you pass, so you usually only need to name the entry-point class (the one with `main`, often `Runner`). When adding a new file, give it the `package` line that matches its directory.

By default `javac` writes each `.class` file next to its `.java` source. To keep build output out of the source tree, pass `-d bin` and run with `-cp bin`:
```console
javac -d bin phase01basic/oop/lesson06/Runner.java
java -cp bin phase01basic.oop.lesson06.Runner
```
`-d bin` recreates the package folders under `bin/` (e.g. `bin/phase01basic/oop/lesson06/Runner.class`). This matches `.vscode/settings.json` (`java.project.outputPath: "bin"`), which is what the VS Code Java extension uses for its own builds — but that setting only affects the extension, **not** the `javac` CLI, so you must pass `-d bin` yourself on the command line. `bin/` is git-ignored.

## Windows console encoding (important)

The default Windows Traditional-Chinese console (cmd) uses MS950/Big5 and will mojibake the UTF-8 Chinese output these programs produce. Before running, switch the console to UTF-8:
```console
chcp 65001
```
Network code (e.g. `lesson15` chat client/server) explicitly forces `StandardCharsets.UTF_8` on all streams rather than relying on the platform default — preserve this when editing; do not reintroduce default-charset stream constructors.

## Conventions

- Modern Java is used and expected: `record` types with compact constructors for validation (`lesson06/RecordCar.java`), `enum` with fields (`lesson05/Role.java`), try-with-resources. Code targets Java 16+.
- Record accessors use the field name directly (`car.brand()`), not `getXxx()`.
- Constructors/compact-constructors throw `IllegalArgumentException` for invalid input.
