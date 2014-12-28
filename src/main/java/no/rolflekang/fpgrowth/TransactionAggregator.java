package no.rolflekang.fpgrowth;

import org.apache.commons.lang3.ArrayUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TransactionAggregator implements Preprocessor {

    private final String delimiter;
    private ArrayList<String> items;
    private HashMap<String, ArrayList<Integer>> transactionMap;
    private ArrayList<int[]> transactions;

    public TransactionAggregator(String delimiter) {
        this.delimiter = delimiter;
        this.items = new ArrayList<String>();
        this.transactionMap = new HashMap<String, ArrayList<Integer>>();
    }

    public void loadDataFile(FileReader fileReader) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] fields = line.split(delimiter);
            if (!transactionMap.containsKey(fields[0])) {
                transactionMap.put(fields[0], new ArrayList<Integer>());
            }
            Integer itemId = getItemId(fields[fields.length - 1]);
            transactionMap.get(fields[0]).add(itemId);
        }
        bufferedReader.close();
    }

    private Integer getItemId(String item) {
        item = item.toLowerCase();
        if (!items.contains(item)) {
            items.add(item);
        }
        return items.indexOf(item);
    }

    private String getItemLabel(int id) {
        return items.get(id);
    }

    public ArrayList<int[]> getTransactions() {
        if (transactions == null) {
            transactions = new ArrayList<int[]>();
            for (ArrayList<Integer> transaction : transactionMap.values()) {
                transactions.add(ArrayUtils.toPrimitive(transaction.toArray(new Integer[transaction.size()])));
            }
        }
        return transactions;
    }

    public List<List<String>> getFrequentItemsetWithLabels(List<List<Integer>> frequentItemsets) {
        List<List<String>> output = new ArrayList<List<String>>();
        for (List<Integer> itemset : frequentItemsets) {
            List<String> itemsetWithLabels = new ArrayList<String>();
            for (Integer item : itemset) {
                itemsetWithLabels.add(getItemLabel(item));
            }
            output.add(itemsetWithLabels);
        }
        return output;
    }
}
