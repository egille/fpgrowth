# FPGrowth [![Build status](https://ci.frigg.io/badges/relekang/fpgrowth/)](https://ci.frigg.io/relekang/fpgrowth/last/)
The project has runnable jar that takes a csv file on the form:
```csv
transaction-number;date;item-identifier
```

## Usage

**Create a jar:**
```bash
git clone git@github.com:relekang/fpgrowth.git && cd fpgrowth
mvn assembly:assembly
```

**Run it:**
```bash
java -jar target/FPGrowth-jar-with-dependencies.jar <path-to-file> <minimum support>
```

MIT © Rolf Erik Lekang
