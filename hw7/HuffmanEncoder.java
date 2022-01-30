import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HuffmanEncoder {
    public static Map<Character, Integer> buildFrequencyTable(char[] inputSymbols) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < inputSymbols.length; i++) {
            if (!map.containsKey(inputSymbols[i])) {
                map.put(inputSymbols[i], 1);
            } else {
                map.put(inputSymbols[i], map.get(inputSymbols[i]) + 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        char[] inputChars = FileUtils.readFile(args[0]);
        String newFile = args[0] + ".huf";
        Map<Character, Integer> frequencyTable = buildFrequencyTable(inputChars);
        BinaryTrie binaryTrie = new BinaryTrie(frequencyTable);
        Map<Character, BitSequence> lookupTable = binaryTrie.buildLookupTable();
        ObjectWriter objectWriter = new ObjectWriter(newFile);
        objectWriter.writeObject(binaryTrie);
        List<BitSequence> list = new ArrayList<>();
        for (char c : inputChars) {
            list.add(lookupTable.get(c));
        }
        BitSequence res = BitSequence.assemble(list);
        objectWriter.writeObject(res);

    }
}
