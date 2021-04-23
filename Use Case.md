# Use Case

|UC #1|Sign Up|
|:---------------------------------------|:---------------------------------------------|
|Related Requirement|FR1|
|Initiating Actor|	Customer, Manager|
|Actor's Goal| 회원가입하여 회원은 회원 권한, 관리자는 관리자 권한을 가진 계정 생성하기|
|Participating Actors| LoginManager, UserTable|
|Preconditions|	1. 생성하려던 아이디가 존재할 경우 다른 아이디로만 신규 가입 가능|
||	2. 아이디 하나는 계정 하나로 취급한다.|
||	3. LoginManager에 계정 정보가 존재하지 않는다.|
|Postconditions|	새 ID와 PW쌍을 UserTable에 저장한다.|
|→1|	사용자로부터 생성하려는 ID를 입력 받는다.|
|←2|	입력 받은 ID가 UserTable에서 중복되는지 아닌지를 검사한다.|
|→3|	중복되는 경우, 사용자로부터 새 ID를 입력받는다.|
|←4|	UserTable에 새 ID와 PW쌍을 저장한다.|
|←5|	성공적으로 완료되었을 경우, Sign up이 성공적으로 종료되었음을 사용자에게 알린다.|

|UC #2|	Sign in|
|:---------------------------------------|:---------------------------------------------|
|Related Requirement|	FR2, FR62, FR3|
|Initiating Actor|	Customer, Manager|
|Actor's Goal|	로그인하여 회원 권한 또는 관리자 권한을 취득한 채로 프로그램을 사용하기|
|Participating Actors|	LoginManager|
|Preconditions|	1. UserTable에 존재하는 ID와 PW쌍으로만 로그인이 가능하다.|
||	2. MaxAuthTry보다 로그인 시도 횟수(NumAuthTry)가 더 많아질 경우, 계정은 잠긴다.|
||	3. LoginManager에 계정 정보가 존재하지 않는다.|
|Postconditions|	LoginManager에 UserAuth로부터 전달받은 UserTable을 저장한다.|
|→1|	사용자로부터 로그인 하려는 ID와 PW쌍을 입력받는다.|
|2|	UC#12 : UserAuth|
|←3|	UserAuth 실패시, NumAuthTry 증가|
|←4|	LoginManager에 해당 계정 정보를 저장한다.|

|UC #3|	Sign out|
|:---------------------------------------|:---------------------------------------------|
|Related Requirement|	FR28|
|Initiating Actor|	Any of : Customer, Manager, Program Handler|
|Actor's Goal|	계정 권한을 지금 당장 사용하지 않을 예정이기 때문에 로그아웃하기|
|Participating Actors|	LoginManager|
|Preconditions|	LoginManager에 저장된 계정 정보가 하나 존재한다.|
|Postconditions|	LoginManager에 저장된 계정 정보를 삭제한다.|
|1|	LoginManager에 저장된 UserTable을 삭제한다.|

|UC #4|	Show Profile|
|:---------------------------------------|:---------------------------------------------|
|Related Requirement|	FR5, FR12, FR39, FR40, FR42|
|Initiating Actor|	Customer, Manager|
|Actor's Goal|	해당 계정의 정보를 열람하기|
|Participating Actors|LoginManager, UserTable|
|Preconditions|	LoginManager에 하나의 계정 정보가 존재한다.|
|Postconditions|	LoginManager에 존재하던 계정 정보를 화면에 출력한다.|
|→1|LoginManager에 계정 정보가 존재하는지 검사한다.|
|←2|	Customer라면, LoginManager에 할당되어 있던 계정 정보를 화면에 출력한다.|
|←3| 관리자라면, UserTable에 접근해 User들의 정보를 출력한다.|

|UC #5|	Set Profile|
|:---------------------------------------|:---------------------------------------------|
|Related Requirement|	FR4, FR12, FR55|
|Initiating Actor|	Customer, Manager|
|Actor's Goal|	해당 계정의 정보를 수정하기|
|Participating Actors|	LoginManager, UserTable|
|Preconditions|	LoginManager에 하나의 계정 정보가 존재한다.|
|Postconditions|	LoginManager에 존재하던 계정에 대해 정보 수정 후, UserTable에 이를 업데이트한다.|
|→1|	LoginManager에 계정 정보가 존재하는지 검사한다.|
|←2|	UC #12 : UserAuth|
|→3|	계정에 대해 수정할 정보를 사용자로부터 입력받는다.|
|←4|	입력받은 정보를 바탕으로, 해당 계정의 UserTable를 갱신한다.|
|←5|	입력받은 정보를 바탕으로, 해당 계정의 LoginManager을 갱신한다.|

|UC-6|	Show Menu List|
|:---------------------------------------|:---------------------------------------------|
|Related Requirement|	FR35|
|Initiating Actor|	Customer, Manager|
|Actor's Goal|	매장에서 판매중인 메뉴들을 모아 보기|
|Participating Actors|	MenuTable|
|Preconditions|	MenuTable에 하나 이상의 메뉴가 들어있다.|
|Postconditions||
|Success Flow||
|→1|	MenuTable 에서 메뉴 목록을 가져온다.|
|→2|	Actor로 부터 받은 정렬 기준에 따라 메뉴 목록을 정렬한다.|
|←3|	화면에 메뉴들을 정렬된 순서로 출력한다.|

|UC-7|	Set Menu|
|:---------------------------------------|:---------------------------------------------|
|Related Requirement|	FR17, FR44, FR45, FR46|
|Initiating Actor|	Manager|
|Actor's Goal|	판매할 수 있는 메뉴를 추가하거나 삭제하기|
||	특정 메뉴에 세부적인 정보, 설명 표기하기|
||	각 메뉴마다 추가하거나 제거할 수 있는 토핑 설정하기|
|Participating Actors|	MenuTable|
|Preconditions||
|Postconditions|	MenuTable에 수정된 정보가 저장된다.|
|Success Scenario	||
|→1|	Actor로 부터 수행할 명령(추가, 수정, 삭제) 과 메뉴의 이름을 입력받는다.|
|→2|	입력 받은 명령이 '수정'이라면 Actor로 부터 수정할 메뉴의 세부 속성을 입력받는다.|
|←3|	MenuTable 에서 해당 메뉴를 찾아서 입력받은 속성으로 수정한다.|
|←4|	사용자에게 수정이 완료되었다고 알린다.|
|Alternate Scenario	||
|2a.| 입력받은 명령이 '추가' 이다.	|
|←1|	MenuTable 에서 해당 이름을 가진 새로운 메뉴를 추가한다.|
|←2| 사용자에게 새로운 메뉴가 추가되었다고 알린다.|
|2b.| 입력받은 명령이 '삭제' 이다.	|
|←1|	MenuTable 에서 해당 이름을 가진 메뉴를 삭제한다.|
|←2|	사용자에게 메뉴가 삭제되었다고 알린다.|

|UC-8|	Show Recommended Menu|
|:---------------------------------------|:---------------------------------------------|
|Related Requirement|	FR34|
|Initiating Actor|	Customer, Manager|
|Actor's Goal|	메뉴 고민을 할 때, 잘 나가는 메뉴나 사장님이 추천하는 메뉴들을 둘러보고 확인하기|
|Participating| Actors	MenuTable|
|Preconditions|	MenuTable에 Recommended 속성을 가지고 있는 메뉴가 하나 이상 있다.|
|Postconditions||
|Success Flow	||
|→1|	MenuTable 에 있는 메뉴 중 Recommended 속성을 가지고 있는 메뉴들을 불러온다.|
|←2|	불러온 메뉴들을 출력한다.|

|UC-9|	Set Recommended Menu|
|:---------------------------------------|:---------------------------------------------|
|Related Requirement|	FR51|
|Initiating Actor|	Manager|
|Actor's Goal	|고객들에게 자신의 매장에서 잘나가거나, 자신이 밀고 싶은 메뉴 추천하기|
|Participating Actors|	MenuTable|
|Preconditions|	MenuTable에 하나 이상의 메뉴가 들어있다.|
||	Actor는 이미 존재하는 메뉴만 추천메뉴로 설정하거나 삭제할 수 있다.|
|Postconditions|	MenuTable에 있는 메뉴 중 선택한 메뉴들에게 Recommended 속성을 추가한다.|
|Success Flow	||
|→1|	Actor로 부터 '추가' 또는 '삭제' 명령과 명령을 수행받고 싶은 메뉴 목록을 입력받는다.|
|←2|	명령이 '추가' 라면, MenuTable 에 있는 메뉴 중 받아온 목록들의 메뉴들에 Recommended 속성을 추가한다.|
|←3| 추가가 완료되었음을 알린다.|
|2a.| 입력받은 명령이 '삭제' 이다.	|
|←1|	명령이 '추가' 라면, MenuTable 에 있는 메뉴 중 받아온 목록들의 메뉴들에 Recommended 속성을 삭제한다.|
|←2|	삭제가 완료되었음을 알린다.|

|UC-10|	Show History Based Menu|
|:---------------------------------------|:---------------------------------------------|
|Related Requirement|	FR33|
|Initiating Actor|	Customer|
|Actor's Goal|	매번 시키는 메뉴들을 짧은 시간 내에 바로바로 편리하게 확인하기|
|Participating| Actors	MenuManager, OrderLogTable|
|Preconditions|	현재 올바른 계정으로 로그인이 되어 있다.|
||	해당 계정으로 이전에 주문했던 기록이 한번이라도 있다.|
||	MenuTable에 하나 이상의 메뉴가 들어있다.|
|Postconditions||
|Success Flow	||
|→1|	OrderLogTable에 있는 현재 로그인 되어있는 계정으로 되어있는 주문 목록을 불러온다.|
|2|	해당 주문 목록 중 가장 많이 주문한 메뉴들을 일부 고른다|
|→3|	MenuTable에 해당 메뉴들이 존재하는지 찾아보고, 존재하는 메뉴들로 새로운 목록을 만든다.|
|←4|	만들어진 목록을 출력한다.|

|UC-11|	Show Food Info|
|:---------------------------------------|:---------------------------------------------|
|Related Requirement|	FR8, FR9|
|Initiating Actor|	Customer, Manager|
|Actor's Goal|	특정 메뉴에 대한 세부적인 정보 보기|
|Participating Actors|	MenuTable|
|Preconditions|	MenuTable에 하나 이상의 메뉴가 들어있다.|
||	Actor는 MenuTable 에 있는 메뉴만 입력할 수 있다.|
|Postconditions	||
|Success Flow	||
|→1|	Actor로 부터 세부정보를 보고 싶은 메뉴의 이름을 입력받는다.|
|→2|	MenuTable에 입력받은 이름과 일치하는 메뉴들의 정보를 가져온다.|
|←3|	해당 메뉴의 속성들을 출력한다.|

|UC #12|	UserAuth (sub-use case)|
|:---------------------------------------|:---------------------------------------------|
|Related Requirement|	NFR4 : 고객의 정보가 임의로 바뀌어서는 안된다.|
|Initiating Actor|	LoginManager|
|Actor's Goal|	UserTable에 해당하는 ID와 PW쌍이 존재하는지 확인하기|
|Participating| Actors	UserTable|
|Preconditions|	1. UserTable에 존재하는 ID와 PW쌍은 유일하다.|
||	2. UserTable에 존재하는 ID와 PW쌍은 별도의 변경 없이는 상태가 유지된다.|
|Postconditions|	요청받았던 해당 UserTable을 전달한다.|
|→1| ID와 PW쌍을 전달받는다.|
|←2| UserTable에 ID와 PW쌍이 존재하는지 검사한다.|
|←3|	존재한다면 해당 사용자의 UserTable을 전달한다.|

|UC #13|	Show Cart|
|:---------------------------------------|:---------------------------------------------|
|Related Requirement|	FR15, FR17, FR18|
|Initiating Actor|	Customer|
|Actor’s Goal|	결제 마지막 단계에서 내 주문으로 다시 검토하고, 총 결제 비용 확인하기|
|Paricipating Actors|	Cart Manager, Order Manager|
|Preconditions||
|Postconditions|	현 장바구니 상태를 보여준다.|
|→ 1|	Customer가 장바구니 버튼을 눌러 장바구니 창으로 이동한다.|
|← 2|	Cart Manager는 현재 Cart를 불러와 Customer에게 보여준다.|

|UC #14|	Set Cart|
|:---------------------------------------|:---------------------------------------------|
|Related Requirement|	FR14, FR15|
|Initiating Actor|	Customer|
|Actor’s Goal|	주문할 때, 주문할 피자의 토핑을 추가하거나 제거하기|
|| 주문하기 전에 장바구니에서 자유롭게 물품들을 넣고 빼기|
|Paricipating Actors|	Cart Manager, Order Manager|
|Preconditions||
|Postconditions|	Customer가 선택한 물품대로 장바구니에 목록이 추가되거나 제거된다.|
|→ 1|	Customer가 장바구니 담기를 누르거나, 장바구니에서 제거 버튼을 누른다.|
|← 2| Cart Manager는 UC-Show menu에서 선택된 상품을 Cart로 옮기거나 제거한다.|

|UC #15|	Show review|
|:---------------------------------------|:---------------------------------------------|
|Related Requirement|	FR31, FR32, FR52, FR60|
|Initiating Actor|	Customer, Manager|
|Actor’s Goal|	기존에 작성된 리뷰를 설정된 기준(평점순, 최신순 등)에 따라 열람할 수 있게 출력하기|
||	리뷰를 작성,수정,답글,삭제를 이용할 수 있게 버튼을 만들기|
|Paricipating Actors|	Review Manager, Login Manager|
|Preconditions|	(로그인이 필요 없다.)|
||	특정 음식메뉴에 ‘리뷰 보기’ 버튼이 존재해야한다.|
||	리뷰 정렬 기준의 기본값(default)은 평점순이다.|
||	리뷰 정렬을 위한 평점순, 최신순 … 등등의 ‘정렬’ 버튼이 존재해야한다.|
|Postconditions|	UC-Set review를 통해 리뷰가 업데이트될 때마다 갱신하여 리뷰를 보여주어야한다.|
||Flow of Events for Main Success Scenario	|
|>1|	Customer(혹은 Manager)가 ‘리뷰 보기’ 버튼을 누른다.|
|<2|	시스템은 Review Manager에게 작성된 리뷰를 불러오도록 요청한다.|
|>3|	Review Manager가 작성된 리뷰를 시스템에 전달한다.|
|<4|	시스템은 작성된 리뷰를 기본값인 평점순으로 정렬하여 Customer(혹은 Manager)에게 출력한다.|
|<5|	시스템은 Login Manager에게 현재 로그인된 Customer(혹은Manager)의 정보를 요청한다.(UC-Show Profile) 요청 정보에는 ID, 주문내역이 포함된다.|
|>6|	Login Manager가 시스템에 요청된 정보를 제공한다.(UC-Show Profile)|
|<7|	시스템은 Customer의 주문내역이 존재한다면 ‘작성’버튼을 활성화한다.|
|<8|	시스템은 리뷰작성자의 ID와 로그인된 Customer의 ID가 동일한 경우 Customer에게 ‘답글’, ‘수정’, ‘삭제’ 버튼을 출력한다.|
||Flow of Events for Extensions(Alternate Scenarios)|
|4(a)|	Customer(혹은 Manager)가 ‘정렬’버튼을 누를 경우 해당하는 기능에 맞도록 정렬하여 출력한다.|
|7(a)|	주문내역이 존재하지 않는다면 ‘작성’버튼을 비활성화한다.|
|8(a)|	ID가 동일하지 않은 경우, ‘작성’, ‘답글’ 버튼을 출력한다.|
|8(b)|	Manager의 경우 항상 ‘답글’, ‘삭제’ 버튼을 출력한다.|

|UC #16|	Set review|
|:---------------------------------------|:---------------------------------------------|
|Related Requirement|	FR29, FR30, FR53, FR55.|
|Initiating Actor|	Customer, Manager|
|Actor’s Goal|	음식에 대한 평가나 의견, 불만사항 등을 글 및 사진의 형태로 업로드(리뷰)하고, 작성된 리뷰를 수정하거나 삭제하기|
|Paricipating Actors|	Review Manager, Login Manager, Alarm|
|Preconditions|	계정이 로그인 되어 있어야한다.|
||	UC-Show review를 통해 ‘작성’,’답글’, ‘수정’, ‘삭제’ 버튼이 존재해야 한다.|
||	Customer는 리뷰를 달기 위해 해당 음식에 대한 주문내역이 있어야한다.|
||	(Manager는 ‘제재’버튼 또한 이용할 수 있어야한다.)|
|Postconditions|	Review Manager는 업데이트된 내용을 Customer, 혹은 Manager(사장)에게 알림을 보내야한다.|
||	리뷰가 업데이트 되면 UC-Show review를 통해 갱신된 리뷰를 Customer(혹은 Manager)에게 보여줘야한다.|
||Flow of Events for Main Success Scenario	|
|>1|	Customer(혹은 Manager)가 활성화된 ‘작성’, ‘답글’, ‘수정’, ‘삭제’ 버튼 중 원하는 버튼을 눌러 Set review에 명령을 전달한다.|
|<2|	시스템(Set review)이 선택된 명령과 입력 정보를 Review Manager에게 전달한다.|
|>3|	Review Manager가 Login Manager에게 현재 로그인된 Customer(혹은 Manager)의 ID를 요청한다. (UC-Show Profile)|
|<4|	Login Manager가Review Manager에게 요청된 정보를 제공한다. (UC-Show Profile)|
|5|	Review Manager가 해당하는 명령을 수행한 후 변경된 내용(Initiator의 ID 포함)을 Table에 업데이트 시킨다.|
|>6|	Review Manager가 업데이트가 되었단 소식을 UC-Notify에 알린다.|
||Flow of Events for Extensions (Alternate Scenarios)	|
|2(a)|	선택된 명령이 ‘작성’일 경우 입력된 내용들을 Review Manager에게 전달한다.|
|2(b)|	선택된 명령이 ‘답글’일 경우 텍스트박스를 만들어 게시할 내용을 입력받아 Review Manager에게 전달한다.|
|2(c)|	선택된 명령이 ‘수정’일 경우 텍스트박스를 만들어 수정할 내용을 입력받아 Review Manager에게 전달한다.|
|2(d)|	(a)선택된 명령이 ‘삭제’일 경우 정말로 삭제할 것인지 prompt를 출력한다. (b)삭제를 눌렀다면 Review Manager에게 명령을 전달한다.|

|UC #17|	Show Mileage|
|:---------------------------------------|:---------------------------------------------|
|Related Requirement|	FR38, FR39, FR40|
|Initiating Actor|	Customer, Order Manager|
|Actor's Goal|	자신의 마일리지 정보를 확인하기|
||	주문할 때, 자신의 마일리지 정보를 확인하기|
|Participating Actors|	Mileage Table, LoginManager|
|Preconditions| Show Profile 에 Show Mileage 의 값이 들어오면 최신 데이터로 업데이트 돼야 한다.|
||	Show Mileage를 사용하려면 로그인이 되어 있어야 한다.|
|Postconditions|	Show Mileage 가 Mileage Manager 와 상호작용 후, Mileage Manager 의 값이 변경되어선 안된다.|
|flow chart|	Scenario 1|
|→1|	고객이 자신의 정보 확인을 요청|
|2|	Show Profile에서 Show Mileage에 마일리지 정보를 전달|
|←3|	Show Mileage는 Mileage Table에서 정보를 받아 Show Profile에 전달|
|←4|	Show Profile에서 마일리지 정보를 출력|
||	Scenario 2|
|→1|	Order Manager 에서 Show Mileage 를 통해 Mileage Table 에 정보 요청|
|←2|	Order Manager 는 Show Mileage 를 통해 Mileage 값 수령|

|UC #18|	Set Mileage|
|:---------------------------------------|:---------------------------------------------|
|Related Requirement|	FR37, FR57, FR58, FR59|
|Initiating Actor|	Order Manager, Manager|
|Actor's Goal|	주문할 때, 자신의 마일리지를 사용하기|
||	특정 회원에게 임의로 마일리지 주기|
||	각각의 메뉴를 주문했을 때 주는 마일리지 양 설정하기|
||	고객의 회원 등급에 따라 주는 마일리지 양 설정하기|
|Participating Actors|	Mileage Table|
|Preconditions|	로그인이 되어 있어야 한다.|
||	Mileage Table 안의 정보 수정 후, 수정 전의 데이터는 삭제 되어야 한다.|
||	Customer 계정은 Set Mileage 의 Initiating Actor 가 될 수 없다.|
|Postconditions	||
|flow chart|	Scenario 1|
|→1|	고객이 결제할 때 Order Manager에 마일리지 사용을 요청|
|←2| Order Manager는 Show Mileage를 통해 마일리지 양 받기|
|→3|	Order Manager는 고객이 사용한 마일리지 양을 Set Mileage 에 전달|
|→4|	Set Mileage는 Mileage Table 에 정보 수정을 요청|
||	Scenario 2|
|→1|	Manager가 Set Mileage 에 고객의 마일리지 정보 수정을 요청|
|→2|	Set Mileage는 Mileage Table 에 정보 수정을 요청|
||	Scenario 3|
|→1|	Manager가 Set Mileage 에 음식 마일리지 정보 수정을 요청|
|→2|	Set Mileage는 Mileage Table 에 정보 수정을 요청|
||	Scenario 4|
|→1|	Manager가 Set Mileage 에 회원 등급에 따른 마일리지 정보 수정을 요청|
|→2|	Set Mileage는 Mileage Table 에 정보 수정을 요청|

|UC #19|	Show Store Info|
|:---------------------------------------|:---------------------------------------------|
|Related Requirement|	FR25, FR49|
|Initiating Actor|	Customer, Manager|
|Actor’s Goal|	(Customer) 매장 전화번호나 주소 등의 정보가 필요한 경우 확인하기|
||	(Manager) 매장의 기간별 또는 메뉴별 매출 통계를 확인하기|
|Paricipating Actors|	Store Table, Login Manager|
|Preconditions|	매출 통계를 확인하는 작업을 위해서는 유효한 관리자 계정으로 로그인 되어있어야 한다.|
|Postconditions	||
||Flow of Main Scenario	|
|→ A.1|	고객은 고객용 앱에서 매장의 정보를 열람하기 위해 매장 정보 버튼을 누른다.|
|← A.2|	Store Table는 테이블에서 해당하는 정보를 읽어온다.|
|A.3|	고객은 그 정보를 확인한다.|
|→ B.1|	관리자는 관리자용 앱에서 매장의 매출을 확인하기 위해 매출 통계 버튼을 누른다.|
|← B.2|	Login Manager는 유효한 관리자 계정으로 로그인이 되어 있는지 확인한다.|
|← B.3|	Store Table는 테이블에서 해당하는 정보를 읽어온다.|
|B.4|	관리자는 그 정보를 확인한다.|

|UC #20|	Set Store Info|
|:---------------------------------------|:---------------------------------------------|
|Related Requirement|	FR41|
|Initiating Actor|	Manager|
|Actor’s Goal|	매장 전화번호나 주소 등의 기본 정보를 수정하기|
|Paricipating Actors|	Store Table, Login Manager|
|Preconditions|	기본 정보를 변경하는 작업을 위해서는 유효한 관리자 계정으로 로그인 되어있어야 한다.|
|Postconditions|	Store Table가 입력받은 새로운 정보로 업데이트 되어야 한다.|
||Flow of Main Scenario	|
|→ 1|	관리자가 기존 정보의 변경을 위해 정보 수정 버튼을 누른다.|
|← 2|	Login Manager는 유효한 관리자 계정으로 로그인이 되어 있는지 확인한다.|
|→ 3|	관리자는 수정할 정보를 입력한다.|
|← 4|	Store Table는 관리자가 입력한 정보로 테이블을 업데이트한다.|

|UC #21|	Notify|
|:---------------------------------------|:---------------------------------------------|
|Related Requirement|	FR24, FR48|
|Initiating Actor|	Alarm|
|Actor’s Goal|	주문이 들어올 때마다 관리자에게 알림 보내기|
|| 주문이 완료될 때 주문내역(영수증)을 profile에 기재된 정보를 통해 알림 보내기|
|Paricipating Actors|	Login Manager, Order Manager, Customer, Manager|
|Preconditions|	알람 조건이 성사되어야만 한다. (고객이 주문을 완료했을 때)|
|Postconditions|	Customer일 경우, 주문내역을 받아보고, Manager일 경우, 주문이 들어왔음을 알림으로 인지한다.|
|→ 1|	Alarm이 상황에 맞는 신호를 전달한다.|
|← 2|	관리자일 경우: 관리자 device에 System 알림을 호출한다. ( 주문 접수됨! )|
|3|	소비자일 경우: Login Manager가 User Table에서 알림을 보낼 주소(포인터)를 가져온다.|
|4|	Order Manager가 UC- Show Cart를 호출해 결제 정보를 넘겨준다.|
|←5|	Alarm은 포인터로 결제정보를 전송한다.|

|UC #22|	Show OrderQueue|
|:---------------------------------------|:---------------------------------------------|
|Related Requirement|	FR27, FR43|
|Initiating Actor|	Manager, Customer|
|Actor’s Goal|	주문 큐에 들어온 주문을 확인하기|
|Paricipating Actors|	OrderQueue Manager, Login Manager|
|Preconditions	||
|Postconditions| 주문 큐를 보여준다.|
|→1|	Manager가 현 주문 보기 버튼을 눌러 주문 창으로 이동한다. Or Customer가 주문 상황 보기를 누른다.|
|←2|	OrderQueue Manager가 주문 큐를 보여준다.|

|UC #23|	Set OrderQueue|
|:---------------------------------------|:---------------------------------------------|
|Related Requirement|	FR47, FR50|
|Initiating Actor|	Order Checker, Manager|
|Actor’s Goal|	주문의 상태를 수정하기( 예상 조리 시간, 취소, 조리중, 배달중 등 현 상황)|
||주문을 주문 큐에 추가하기|
|Paricipating Actors|	OrderQueue Manager|
|Preconditions|	큐에 주문이 있을 때에만 수정할 수 있다.|
||관리자는 관리자 계정으로 로그인 되어있어야 한다.|
|Postconditions|	요청받은 데이터를 큐에 저장하거나 삭제한다.|
|→1|	주문 큐의 데이터를 처리하는 요청을 OrderQueue Manager가 받는다.|
|→2|	OrderQueue Manager는 들어온 요청을 수행하고 큐를 저장한다.|

|UC #24|	Order|
|:---------------------------------------|:---------------------------------------------|
|Related Requirement|	FR06, FR07, FR11, FR12, FR13, FR16, FR21, FR22, FR23|
|Initiating Actor|	Customer|
|Actor’s Goal|	피자를 주문하기 위해서 영업시간을 확인하고, 영업시간 내에 피자를 주문하기|
|| 장바구니에 있는 물품들을 한 번에 편리하게 주문하기|
|| 결제 방법으로 카드와 현금 중 선택해 주문하기|
|| 수령 방법으로 배달, 매장 식사, 픽업 중 선택해 주문하기|
|| 주문할 때, 본인의 요청 사항을 기재하기|
|| 결제를 실패한다면 다시 동일한 내용으로 결제를 시도하기|
|Paricipating Actors|	Order Manager, Customer, Order Checker, Alarm, Mileage Table|
|Preconditions|	장바구니에 물품이 담겨있어야 한다.|
|Postconditions	|결제 상황이 종료되어야 하고, 그에 따른 장바구니와 프로필이 업데이트 되어야 한다.|
||	Flow of Events for Main Success Scenario||
|→ 1|	Customer가 결제 버튼을 눌러 결제 창으로 이동한다.|
|← 2|	Order Manager 는 UC- Show Cart를 호출해 현재 결제할 정보를 Customer에게 제공한다.|
|→ 3|	Customer는 결제 방법, 수령 방법, 마일리지 사용 여부 요청사항 등을 Order Manager에게 전달한다.|
|← 4|	마일리지를 사용한다면 Order Manager는 UC-Show Mileage를 호출해 Customer에게 제공한다.|
|→ 5|	Customer는 사용할 마일리지를 설정하고, 결제를 눌러 결제를 시도한다.|
|6|	Order Manager는 결제를 승인하고 성공여부에 따라 다음 절차를 따른다.(Order Manager는 결제를 승인한다)|
||	Flow of Events for Extensions (Alternate Scenarios)|
|6(a)|	"성공: Order Manager는 UC-Set Mileage과 UC-Set Cart를 호출해 변동사항을 저장한다. Alarm은 UC-Notify를 initiate한다. |
|| Order Manager는 Order Checker에 주문의 내용을 전달한다. Order Checker는 Set OrderQueue 를 initiate한다."|
|6(b)|	실패 : Order Manager는 결제가 실패했음을 Customer에게 전달하고, 다시 2. 로 돌아간다.|
