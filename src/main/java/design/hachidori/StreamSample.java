package design.hachidori;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSample {

    public static void main(String[] args) {
        List<Integer> argList = Arrays.stream(args).map(Integer::parseInt).collect(Collectors.toList());
        StreamSample sample = new StreamSample();
        sample.arrange(argList)
                .stream()
                .forEach(System.out::println);
    }

    /**
     * 以下の処理をしたlist返します
     * <p>
     * - 100以上の数値は除外する
     * - 1の位が3の場合は除外する
     * - 重複を除外する
     * - 降順ソート
     * - 3番目~6番目の要素に絞った結果のリストを返す
     * ^ 元のListを破壊しない
     */
    public List arrange(List<Integer> list) {
            return list.stream()
                    .filter(aaa -> aaa < 100 && aaa % 10 != 3)
                    .distinct()
                    .skip(2).limit(4)
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList());
    }
}
