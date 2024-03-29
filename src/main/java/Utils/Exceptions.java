package Utils;

import java.util.List;

public class Exceptions {
    public static final Exceptions EXCEPTIONS = new Exceptions();
    private static final int LOTTO_LENGTH = 6;
    private static final String ERROR_MESSAGE = "[ERROR]";

    public void ExcludeUnderThousand(String readLine) {
        if (!readLine.matches("^[0-9]*?") || readLine.equals("") || readLine.isBlank() || Integer.parseInt(readLine) <= 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 양의 정수만 입력가능합니다.");
        }
        if (Integer.parseInt(readLine) % 1000 > 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 1000원 단위로 입력해야 합니다.");
        }
    }

    public void ExcludeNoLottoNumbers(List<String> winningNumbers) {
        if (winningNumbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 양의 정수 6개를 입력해야 합니다.");
        }
        if (winningNumbers.size() != winningNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 중복되는 숫자가 입력되었습니다.");
        }
        for (int i = 0; i < LOTTO_LENGTH; i++) {
            if (!winningNumbers.get(i).matches("-?\\d+")) {
                throw new IllegalArgumentException(ERROR_MESSAGE + " 1~45사이의 정수를 입력해야 합니다.");
            }
            if (Integer.parseInt(winningNumbers.get(i)) < 1 || Integer.parseInt(winningNumbers.get(i)) > 45) {
                throw new IllegalArgumentException(ERROR_MESSAGE + " 로또 번호는 1부터 45사이의 숫자여야 합니다.");
            }
        }
    }

    public void ExcludeNoBonusNumber(String bonusNumber) {
        if (!bonusNumber.matches("-?\\d+")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 1~45사이의 정수를 입력해야 합니다.");
        }
        if (Integer.parseInt(bonusNumber) < 1 || Integer.parseInt(bonusNumber) > 45) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 로또 번호는 1부터 45사이의 숫자여야 합니다.");
        }
    }

    public void ValidateNumbersDuplication(List<List<String>> winningNumbers) {
        if (winningNumbers.get(0).contains(winningNumbers.get(1).get(0))) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 당첨 번호와 보너스 번호가 중복되었습니다.");
        }
    }

}
