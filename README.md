# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)


---
# 기능 요구사항 정리


### Ball

- 1~9 의 숫자
- 다른 Ball 과 비교 가능 


### Balls

- 서로 다른 Ball 로 구성된 콜렉션 (최대 길이 3)
- 다른 Balls 를 입력 받고 비교하여 볼의 결과 반환 


### BallResult

- 스트라이크와 볼의 수 제공 
- 모두 스트라이크인지 확인 (게임이 완료됨)


### Computer

- 기준이 되는 랜덤 숫자 제공


### GameMenu

- 게임 관련 메뉴 enum
- 입력값이 새 게임인지 여부 판단