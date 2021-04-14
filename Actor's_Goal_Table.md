Deriving Use Cases from System Requirements
=============

Classified according to keywords

## Mileage

| Actor | Actor’s goal | Use Case |
|:---:|:---:|:---:|	
| Customer | 자신의 마일리지 정보(총 획득량, 현재 보유량)를 확인하기 | Show Profile, Show Mileage|
| Customer | 자신의 회원 등급에 따른 마일리지 획득량 확인하기 | Show Profile, Set Mileage |
| Customer | 자신의 회원 등급과 주문한 메뉴에 따른 마일리지 획득하기 | Order, Show Mileage, Set Mileage |
| Customer | 주문할 때, 자신의 마일리지를 사용하기 | Order, Show Mileage |
| Manager | 특정 회원에게 임의로 마일리지 주기 | Show Mileage, Set Mileage |
| Manager | 각각의 메뉴를 주문했을 때 주는 마일리지 양 설정하기 | Set Mileage |
| Manager | 고객의 회원 등급에 따라 주는 마일리지 양 설정하기 | Set Mileage |
___
	
## Store
| Actor | Actor’s goal | Use Case |
|:---:|:---:|:---:|
| Customer | 매장 직원과 대화가 필요할 경우 매장과 통화 연결하기 | Show Store Info |
| Manager | 계정을 생성했을때 또는 필요 시 매장의 영업시간을 설정하기 | Set Store Info |
| Manager | 매장의 기간별 및 메뉴별 매출 통계를 확인하기 | Show Store Info |
| Store DB Manager | 매장 정보에 대해 열람, 수정 등의 요청이 있을 경우 Store DB로부터 해당되는 작업을 수행하기 | Show Store Info / Set Store Info |
___

## Profile
| Actor | Actor’s goal | Use Case |
|:---:|:---:|:---:|
| Customer | 회원가입하여 마일리지, 추천 메뉴 등 회원 혜택을 누리기 | Sign up |
| Customer | 로그인하여 회원 상태로 프로그램 사용하기 | Sign in |
| Customer | 더 이상 이 프로그램을 사용하고 싶지 않아 회원 정보 삭제하기 | Set Profile |
| Customer | 내가 이전에 했던 주문 정보 열람 하기 | Show profile |
| Customer | 주문에 필요한 주소와 전화번호 미리 등록하기 | Set Profile |
| Customer | 내 마일리지와 회원 등급 현황 보기 | Show profile, Show mileage |
| Manager | 회원가입하여 관리자 권한으로 프로그램 사용하기 | Sign up |
| Manager | 로그인하여 관리자 상태로 프로그램 사용하기 | Sign in |
| Manager | 고객들의 회원 정보 열람하기 | Show profile |
| Manager | 악성 회원 정지, 삭제 등 제재하기 | Show Profile, Set Profile |
| Program Handler | 프로그램이 종료되었을 때 현재 로그인 된 계정 로그아웃하기 | Sign out |
___

## Review
| Actor | Actor’s goal | Use Case |
|:---:|:---:|:---:|
| Customer | 음식에 대한 평가나 의견, 불만사항 등을 글 및 사진의 형태로 업로드(리뷰)하기 | Set review |
| Customer | 다른 사람 혹은 자신이 작성한 리뷰를 열람하고 필요에 따라 수정하거나 삭제하기 | Show review, Set review |
| Customer, Manager | 작성된 리뷰들을 평점순, 최신순 등 기준에 맞게 정렬하여 보여주기 | Show review |
| Customer | 작성한 리뷰가 제대로 작성되어 업로드까지 잘 되었는지 확인 | Show review |
| Manager | Admin이 직접 특정 음식을 선택하여 해당 음식의 리뷰를 보거나 review list를 통해Customer가 작성한 리뷰를 확인하고 답글 달기 | Show food info, Show review, Set review |
| Manager | 폭언, 욕설 같은 불건전한 내용이 담긴 리뷰를 수정하거나 삭제하고, 해당 리뷰를 남긴 회원에게 제재를 가할 수 있게 회원정보를 열람할 권한을 부여하기 | Show review, Set review, Show profile, Set profile |
| Alarm | Customer가 리뷰를 작성하면 Manager가 작성된 리뷰를 인지하도록 알림 보내기 | Notify, show review |
___

## Order
| Actor | Actor’s goal | Use Case |
|:---:|:---:|:---:|
| Customer | 피자를 주문하기 위해서 영업시간을 확인하고, 영업시간 내에 피자를 주문하기 | Order, Show store Info |
| Customer | 장바구니에 있는 물품들을 한 번에 편리하게 주문하기 | Order, Show Cart |
| Customer | 매번 시키는 메뉴들을 짧은 시간 내에 바로바로 편리하게 확인하기 | Show History based menu |
| Customer | 메뉴 고민을 할 때, 잘 나가는 메뉴나 사장님이 추천하는 메뉴들을 둘러보고 확인하기 | Show Recommended menu |
| Customer | 결제 방법으로 카드와 현금 중 선택해 주문하기 | Order |
| Customer | 수령 방법으로 배달, 매장식사, 픽업 중 선택해 주문하기 | Order |
| Customer | 결제 하기 직전에 마일리지를 사용할지 결정하고, 사용한다면 얼마나 사용할지 결정하기 | Order, Show mileage |
| Customer | 주문할 때, 주문할 피자의 토핑을 추가하거나 제거하기 | Set Cart, Show menu |
| Customer | 주문할 때, 본인의 요청사항을 기재하기(언제까지 어떻게 배달해주세요) | Order |
| Customer | 주문하려는 메뉴가 품절되지는 않았는지 확인하기 | Show menu |
| Customer | 주문할 때 배달받을 주소를 작성하고, 혹은 저장된 주소를 불러오기 | Set profile, Show profile |
| Customer | 주문하기 전에 장바구니에서 자유롭게 물품들을 넣고 빼기 | Set Cart |
| Customer | 언제쯤 배달을 받아 볼 수 있을지 확인하기 | Show OrderQueue |
| Customer | 결제를 실패한다면 다시 동일한 내용으로 결제를 시도하기 | Order |
| Customer | 주문한 뒤 주문내역(영수증)을 profile에 기재된 정보(번호를)를 통해 알림으로 받아보기 | Order, Show profile, Notify, Show Cart |
| Customer | 결제 마지막 단계에서 내 주문을 다시 검토하고, 총 결제 비용 확인하기 | Order, Show Cart |
| Manager | 주문큐에 들어온 주문을 확인하기 | Show OrderQueue |
| Manager | 주문의 상태를 수정하기(예상 조리 시간, 취소, 조리중, 배달중 등등 현 상황) | Set OrderQueue |
| Order Checker | 주문이 들어왔음을 알리고, 주문 큐에 새로운 주문 넣기 | Set OrderQueue |
| Timer | 영업시간 종료 이후로는 주문 기능을 비활성화 하기 | Show store Info |
| Alarm | 주문이 완료될 때마다 관리자에게 알람 보내기 | Notify |
___

## Menu
| Actor | Actor’s goal | Use Case |
|:---:|:---:|:---:|
| Customer | 매장에서 판매중인 메뉴들을 모아 보기 | Show menu |
| Customer | 특정 메뉴에 대한 세부적인 정보 보기 | Show Food Info |
| Customer | 특정 메뉴가 주문이 가능한지 알기 | Show Food Info |
| Customer | 매장에서 추천하는 메뉴 보기 | Show Recommended Menu |
| Manager | 판매할 수 있는 메뉴를 추가하거나 수정, 삭제하기 | Set Menu |
| Manager | 특정 메뉴에 세부적인 정보, 설명 표기하기 | Set Food Info |
| Manager | 각 메뉴마다 추가하거나 제거할 수 있는 토핑 설정하기 | Set Food Info |
| Manager | 고객들에게 자신의 매장에서 잘나가거나, 자신이 밀고 싶은 메뉴 추천하기 | Set Recommended Menu |

