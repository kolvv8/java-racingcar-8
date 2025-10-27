package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_미입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> run("", "1")) // 이름으로 빈 문자열 입력
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 공백_이름_스페이스_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> run(" ", "1")) // 이름으로 공백만 입력
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 공백_이름_연속_쉼표_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> run("pobi,,woni", "1")) // 쉼표 연속
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_뒤_쉼표_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> run("pobi,woni,", "1")) // 마지막에 쉼표
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_앞_쉼표_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> run(",pobi,woni", "1")) // 처음에 쉼표
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_중복_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> run("pobi,pobi,woni", "1")) // "pobi" 중복
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_공백_포함_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> run("pobi, wo ni", "1")) // " wo ni"에 공백 포함
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 횟수_공백_스페이스_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> run("pobi,woni", " ")) // 횟수로 공백만 입력
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 횟수_문자_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> run("pobi,woni", "a")) // 횟수로 문자 'a' 입력
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 횟수_0_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> run("pobi,woni", "0")) // 0은 자연수가 아님
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 횟수_음수_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> run("pobi,woni", "-1")) // 음수는 자연수가 아님
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 횟수_소수점_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> run("pobi,woni", "1.5")) // 소수점은 정수가 아님
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
