package baseball.domain;

import baseball.exception.InvalidGameMenuException;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameMenuTest {

    @Test
    @DisplayName("게임 메뉴 입력 - 없는 메뉴 입력")
    public void 게임메뉴입력_없는메뉴입력() {
        // given
        String menu = "a";

        // when
        ThrowingCallable throwingCallable = () -> GameMenu.isNewGame(menu);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(InvalidGameMenuException.class);
    }

    @Test
    @DisplayName("게임 메뉴 입력 - 새 게임")
    public void 게임메뉴입력_새게임() {
        // given
        String menu = "1";

        // when
        boolean isNewGame = GameMenu.isNewGame(menu);

        // then
        assertThat(isNewGame).isTrue();
    }

    @Test
    @DisplayName("게임 메뉴 입력 - 종료")
    public void 게임메뉴입력_종료() {
        // given
        String menu = "2";

        // when
        boolean isNewGame = GameMenu.isNewGame(menu);

        // then
        assertThat(isNewGame).isFalse();
    }

}