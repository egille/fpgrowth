# FPGrowth [![Build status](https://ci.frigg.io/badges/egille/fpgrowth/)](https://ci.frigg.io/egille/fpgrowth/last/)
The project has runnable jar that takes a csv file on the form:
```csv
transaction-number,date,item-identifier
```
The file can have different delimiters specified as the third argument.
There can be many fields between `transaction-number` and `item-identifier`
since the code only uses the first and the last

## Usage

**Create a jar:**
```bash
git clone git@github.com:relekang/fpgrowth.git && cd fpgrowth
mvn compile assembly:assembly
```

**Run it:**
```bash
java -jar target/FPGrowth-jar-with-dependencies.jar path-to-file minimum support [delimiter]
```

## Installation
Install jdk and [maven](http://maven.apache.org/download.cgi)

MIT © Rolf Erik Lekang
