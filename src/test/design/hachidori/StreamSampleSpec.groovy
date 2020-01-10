package design.hachidori

import spock.lang.Specification

class StreamSampleSpec extends Specification {

    def "サンプルでテスト"() {
        setup:
        StreamSample sut = new StreamSample();

        expect:
        result == sut.arrange(arrays)

        where:
        arrays                                        | result
        [1, 1, 2, 5, 7, 21, 23, 35, 70, 71, 100, 120] | [35, 21, 7, 5]
    }

    def "重複除外テスト"() {
        setup:
        StreamSample sut = new StreamSample();

        expect:
        result == sut.arrange(arrays)

        where:
        arrays                   | result
        [4, 4, 4, 4, 4, 5, 6, 6] | [6]
    }

    def "3~6番目の要素のみ取得"() {
        setup:
        StreamSample sut = new StreamSample();

        expect:
        result == sut.arrange(arrays)

        where:
        arrays                | result
        [1, 2, 4, 5, 6, 7, 8] | [7, 6, 5, 4]
    }


    def "3を除く"() {
        setup:
        StreamSample sut = new StreamSample();

        expect:
        result == sut.arrange(arrays)

        where:
        arrays                                     | result
        [-3, -2, -1, 0, 1, 2, 3, 4, 5, 13, 23, 30] | [2, 1, 0, -1]
    }

    def "境界値 100以上の数値は除外"() {
        setup:
        StreamSample sut = new StreamSample();

        expect:
        result == sut.arrange(arrays)

        where:
        arrays                           | result
        [-1, 0, 1, 2, 99, 100, 101, 102] | [99, 2, 1]
    }
}
