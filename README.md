# 백승호 202130213 

## 6월 7일 강의
스윙 컴포넌트 그리기, paintComponent()
- 스윙의 페인팅 기본
    1. 모든 컴포넌트는 자신의 모양을 스스로 그린다.
    2. 컨테이너는 자신을 그린 후 그 위에 자식 컴포넌트들에게 그리기 지시
    3. 모든 스윙 컴포넌트는 자신의 모양을 그리는 paintComponent() 메소드 보유

- public void paintComponent(Graphics g)
    1. 스윙 컴포넌트가 자신의 모양을 그리는 메소드
    2. JComponent의 메소드 : 모든 스윙 컴포넌트가 이 메소드를 오버라이딩함
    3. 언제 호출되는가?
        컴포넌트가 그려져야 하는 시점마다 호출
        크기가 변경되거나, 위치가 변경되거나, 컴포넌트가 가려졌던 것이 사라지는 등
    4. 매개변수인 Graphics 객체
        그래픽 컨텍스트 : 컴포넌트 그리기에 필요한 도구를 제공하는 객체
        자바 플랫폼에 의해 공급
        색 지정, 도형 그리기, 클리핑, 이미지 그리기 등의 메소드 제공

- paintComponent()의 오버라이딩
    1. 개발자가 JComponent를 상속받아 새로운 컴포넌트 설계
    2. 기존 컴포넌트의 모양에 변화를 주고자 할 때

- JPanel
    1. 비어 있는 컨테이너
    2. 개발자가 다양한 GUI를 창출할 수 있는 캔버스로 적합
    3. JPanel을 상속받아 개발자 임의의 모양을 가지는 패널로 많이 사용

연습 ) paintJPanelEx.java

- 그래픽 기반 GUI 프로그래밍
    1. 스윙 컴포넌트에 의존하지 않고 선, 원 이미지 등을 이용하여 직접 화면을 구성하는 방법
    2. 그래픽 기반 GUI 프로그래밍의 학습이 필요한 이유
        컴포넌트의 한계를 극복하고 차트, 게임 등 자유로운 콘텐트 표현
        그래픽은 컴포넌트에 비해 화면 출력 속도가 빠름
        스윙 컴포넌트들로 모두 그래픽으로 작성되어 있어, 그래픽에 대한 학습은 자바 GUI의 바탕 기술을 이해하는데 도움
        그래픽을 이용하여 개발자가 자신만의 컴포넌트 개발

Graphics와 문자열 출력
- Graphics의 기능
    1. 색상 선택하기
    2. 문자열 그리기
    3. 도형 그리기 
    4. 도형 칠하기
    5. 이미지 그리기
    6. 클리핑

- 문자열 출력을 위한 Graphics 메소드
    void drawString(String str, int x, int y)
        str 문자열을 (x,y) 영역에 그림. 현재 Graphics에 설정된 색과 폰트로 문자열 출력


그래픽의 색과 폰트
- 색: Color 클래스
    1. 자바의 색: r(Red), g(Green), b(Blue) 성분으로 구성, 각 성분은 0~255(8비트) 범위의 정수
    예) 빨간색: new Color(255,0,0), 초록색: new Color(0x0000ff00); 노란색: Color.YELLOW

- 폰트: Font 클래스
    1. fontFace: "고딕체", "Atriel" 등과 같은 폰트 이름
    2. style: Font.BOLD, Font.ITALIC, Font.PLAIN 중 한 값으로 문자의 스타일
    3. size: 픽셀 단위의 문자 크기

- Graphics에 색과 폰트 설정
    1. void setColor(Color color) 그래픽 색을 color로 설정. 그리기 시에 색으로 이용
    2. void setFont(Font font) 그래픽 폰트를 font로 설정.문자열 출력 시 폰트로 이용

연습 ) GraphicsColorFontEx.java


도형 그리기와 칠학
- 도형 그리기
    1. 선, 타원, 사각형, 둥근 모서리 사각형, 폐 다각형 그리기
    2. 선의 굵기 조절할 수 없음

    void drawLine(int x1, int y1, int x2, int y2)
        (x1,y1)에서 (x2,y2)까지 선을 그린다.
    void drawOval(int x, int y, int w, int h)
        (x,y)에서 w x h 크기의 사각형에 내접하는 타원을 그린다.
    void drawRect(int x, int y, int w, int h)
        (x,y)에서 w x h 크기의 사격형을 그린다.
    void drawRoundRect(int x, int y, int w, int h, int arcWidth, int arcHeight)
    - arcWidth: 모서리 원의 수평 반지름
    - arcHeight: 모서리 원의 수직 반지름
        (x,y)에서 w x h 크기의 사각형을 그리되, 4개의 모서리는 arcWidth와 arcHeight를 이용하여 원호로 그린다.
    
- 도형 칠하기
    1. 도형을 그리고 내부를 칠하는 기능
        도형의 외곽선과 내부를 따로 칠하는 기능 없음
    2. 도형 칠하기를 위한 메소드
        그리기 메소드 명에서 draw 대신 fill로 이름 대치하면 됨. fillRect(), fillOval() 등

    연습) GraphicsDrawLineEx.java 연습


- Graphics의 원호와 폐다각형 그리기 메소드
    void drawArc(int x, int y, int w, int h, int startAngle, int arcAngle)
    - stratAngle: 원호의 시작 각도
    - arcAngle: 원호 각도
        (x,y)에서 w x h 크기의 사각형에 내접하는 원호를 그린다. 3시 방향이 0도의 기점이다. statAngle 지점에서 arcAngle 각도만큼 원호를 그린다. argAngle이 양수이면 반시계 방향, 음수이면 시계 방향으로 그린다.
    void drawPolygon(int []x, int []y, int n)
        x,y 배열에 저장된 점들 중 n개를 연결하는 폐다각형을 그린다. (x[0], y[0], x[1], y[1]), ... , (x[n-1],y[n-1]), (x[0], y[0])의 점들을 순서대로 연결한다.

연습 ) GraphicsFillEx.java


스윙에서 이미지를 그리는 2 가지 방법
1. JLabel을 이용한 이미지 그리기
    imagelcon image = new Imageicon("images/apple/jpg");
    JLabel label = new JLabel(image);
    panel.add(label);
    - 장점 : 이미지 그리기 간편 용이
    - 단점 : 이미지의 원본 크기대로 그리므로 이미지 크기 조절 불가

2. Graphics의 drawImage()로 이미지 출력
    - 장점 : 이미지 일부분 등 이미지의 원본 크기와 다르게 그리기 가능
    - 단점 : 컴포넌트로 관리할 수 없음 이미지의 취나 크기 등을 적절히 조절하는 코딩 필요

Graphics의 drawImage()메소드
- 원본 크기로 그리기   
    booLean drawImage(Image img, int x, int y, Color bgColor, ImageObserver observer)
    booLean drawImage(Image img, int x, int y, ImageObserver observer)
    - img: 이미지 객체
    - x,y: 이미지가 그려질 좌표
    - bgColor: 이미지가 투명한 부분을 가지고 있을 때 투명한 부분에 칠해지는 색상
    - observer: 이미지 그리기의 완료를 통보받는 객체

- 크기 조절하여 그리기
    booLean drawImage(Image img, int x, int y, int width, int height, Color bgColor, ImageObserver observer)
    booLean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer)
    - width: 그려지는 폭으로서 픽셀 단위
    - height: 그려지는 높이로서 픽셀 단위

연습 ) GraphicsDrawImageEx1.java, GraphicsDrawImageEx2.java

- repaint()
    1. 모든 컴포넌트가 가지고 있는 메소드
    2. 자바 플랫폼에게 컴포넌트 그리기를 강제 지시하는 메소드
    3. repaint()를 호출하면, 자바 플랫폼이 컴포넌트의 paintComponent() 호출

- repaint()의 호출이 필요한 경우
    개발자가 컴포넌트를 다시 그리고자 하는 경우
    1. 프로그램에서 컴포넌트의 모양과 위치를 변경하고 바로 화면에 반영시키고자 하는 경우
    2. 컴포넌트가 다시 그려져야 그 때 변경된 위치에 변경된 모양으로 출력됨
    3. repaint()는 자바 플랫폼에게 지금 당장 컴포넌트를 다시 그리도록 지시함

- 부모 컴포넌트부터 다시 그리는 것이 좋음
    1. 컴포넌트 repaint()가 불려지면
        이 컴포넌트는 새로운 위치에 다시 그려지지만 이전의 위치에 있던 자신의 모양이 남아 있음
    2. 부모 컴포넌트의 repaint()를 호출하면
        부모 컨테이너의 모든 내용을 지우고 자식을 다시 그리기 때문에 컴포넌트의 이전 모양이 지워지고 새로 변경된 크기나 위치에 그려짐

연습 ) GraphicsDrawOvalMouseEx.java 


- 멀티태스킹
    여러 개의 작업(태크스)이 동시에 처리되는 것

스레드와 운영체제
- 스레드(thread)
    1. 운영체제에 의해 관리되는 하나의 작업 혹은 태스크
    2. 스레드와 태스크(혹은 작업)은 바꾸어 사용해도 무관

- 멀티스레딩(mult-threading)
    1. 여러 스레드를 동시에 실행시키는 응용프로그램을 작성하는 기법

- 스레드 구성
    1. 스레드 코드
        작업을 실행하기 위해 작성한 프로그램 코드
        개발자가 작성
    2. 스레드 정보
        스레드 명, 스레드 ID, 스레드의 실행 소요 시간, 스레드의 우선 순위 등
        운영체제가 스레드에 대해 관리하는 정보
    
멀티태스킹과 멀티스레딩
(멀티태스킹 구현 기술)
 - 멀티프로세싱(multi-processing)
    1. 하나의 응용프로그램이 여러 개의 프로세스를 생성하고, 각 프로세스가 하나의 작업을 처리하는 기법
    2. 각 프로세스 독립된 메모리 영역을 보유하고 실행
    3. 프로세스 사이의 문맥 교환에 따른 과도한 오버헤드와 시간 소모의 문제점

 - 멀티스레딩(multi-threading)
    1. 하나의 응응프로그램이 여러 개의 스레드를 생성하고, 각 스레드가 하나의 작업을 처리하는 기법
    2. 하나의 응용프로그램에 속한 스레드는 변수 메모리, 파일 오픈 테이블 등 자원으로 공유하므로, 문맥 교환에 따른 오버헤드가 매주 작음
    3. 현재 대부분의 운영체제가 멀티스레딩을 기본으로 하고 있음


자바 스레드(Thread)와 JVM
- 자바 스레드
    1. 자바 가상 기계(JVM)에 의해 스케쥴되는 실행 단위위 코드 블럭
    2. 스레드의 생명 주기는 JVM에 의해 관리됨 : JVM은 스레드 단위로 스케쥴링

- JVM과 자바의 멀티스레딩
    1. 하나의 JVM은 하나의 자바 응용프로그램만 실행
        자바 응용프로그램이 시작될 때 JVM이 함께 실행됨
        자바 응용프로그램이 종료하면 JVM도 함께 종료함
- 응용프로그램은 하나 이상의 스레드로 구성 가능


Thread 클래스를 상속받아 스레드 만들기
- Thread를 상속받아 run() 오버라이딩
    1. Thread 클래스 상속. 새 클래스 작성
    2. run() 메소드 작성
        run() 메소드를 스레드 코드라고 부름
        run() 메소드에서 스레드 실행 시작
- 스레드 객체 생성
    생성된 객체는 필드와 메소드를 가진 객체일 뿐 스레드로 작동하지 않음
- 스레드 시작
    start()메소드 호출
    1. 스레드로 작동 시작
    2. 스레드 객체의 run()이 비로소 실행
    3. JVM에 의해 스케쥴되기 시작함

연습 ) ThreadTimerEx.java

Runnable 인터페이스로 스레드 만들기
- Runnable 인터페이스 구현하는 새 클래스 작성
    run() 메소드 구현
        1. run() 메소드를 스레드 코드라고 부름
        2. run() 메소드에서 스레드 실행 시작
- 스레드 객체 생성
- 스레드 시작
    start() 메소드 호출
    1. 스레드로 작동 시작
    2. 스레드 객체의 run()이 비로소 실행
    3. JVM에 의해 스케줄되기 시작함

- main 스레드
    JVM이 응용프로그램을 실행할 때 디폴트로 생성되는 스레드
    1. main() 메소드 실행 시작
    2. main() 메소드가 종료하면 main 스레드 종료

스레드 종료와 타 스레드 강제 종료
 스스로 종료
 1. run() 메소드 리턴

 타 스트레드에서 강제 종료
 1. interrupt() 메소드 사용

연습 ) VibrationgFrame.java

스레드 동기화(Thread Synchronization)
- 멀티스레드 프로그램 작성시 주의점
    1. 다수의 스레드가 공유 데이터에 동시에 접근하는 경우
        공유 데이터의 값에 예상치 못한 결과 발생 가능
- 스레드 동기화
    (동기화): 스레드 사이의 실행순서 제어, 공유데이터에 대한 접근을 원활하게 하는 기법
    (멀티스레드의 공유 데이터의 동시 접근 문제 해결)
    1. 공유 데이터를 접근하는 모든 스레드의 한 줄 세우기
    2. 한 스레드가 공유 데이터에 대한 작업을 끝낼 때까지 다른 스레드가 대기 하도록 함

synchronized 블록 지정
- synchronized 키워드 
    스레드가 독점적으로 실행해야 하는 부분(동기화 코드)을 표시하는 키워드
    ) 임계 영역(criitical section) 표기 키워드

    synchronized 블록 지정 방법
        메소드 전체 혹은 코드 블록
    
- synchronized 블록이 실행될 때
 먼저 실행한 스레드가 모니터 소유
    ) 모니터란 해당 객체를 독점적으로 사용할 수 있는 권한
모니터를 소유한 스레드가 모니터를 내놓을 때까지 다른 스레드 대기


wait()-notify()를 이용한 스레드 동기화
- wait()-notify()가 필요한 경우
    1. 공유 데이터로 두 개 이상의 스레드가 데이터를 주고 받을 때
        producer-consumer문제
- 동기화 메소드
    1. wait(): 다른 스레드가 notify()를 불러줄 때까지 기다린다.
    2. notify(): wait()를 호출하여 대기중인 스레드를 깨운다
        wait(), notify()는 Object의 메소드





## 5월 31일 강의
자바의 GUI 프로그래밍 방법 2종류
- 컴포넌트 기반 GUI 프로그래밍
    1. 스윙 컴포넌트를 이용하여 쉽게 GUI를 구축
    2. 자바에서 제공하는 컴포넌트의 한계를 벗어나지 못함
- 그래픽 기반 GUI 프로그래밍
    1. 그래픽을 이용하여 GUI 구축
    2. 개발자가 직접 그래픽으로 화면을 구성하는 부담
    3. 독특한 GUI를 구성할 수 있는 장점
    4. GUI 처리의 실행 속도가 빨라, 게임 등에 주로 이용

스윙 컴포넌트의 공통 메소드, JComponent의 메소드
- JComponent
    1. 스윙 컴포넌트는 모두 상속받는 슈퍼 클래스, 추상 클래스
    2. 스윙 컴포넌트들이 상속받는 공통 메소드와 상수 구현
    3. JComponent의 주요 메소드 사례
연습) JComponentEx.java

JLabel로 문자열과 이미지 출력
- JLabel의 용도
    1. 문자열이나 이미지를 화면에 출력하기 위한 목적
- 레이블 생성
    1. JLabel() 빈레이블
    2. JLabel(Icon image) 이미지 레이블
    3. JLabel(String text) 문자열 레이블
    4. JLabel(String text, Icon image, int hAlign) 문자열과 이미지 모두 가진 레이블
    5. hAlign: 수평 정렬 값으로 SwingConstants.LEFT, SwingConstants.RIGHT, SwingConstants.CENTER 중하나

레이블 생성 예
- 문자열 레이블 생성
    JLabel textLabel = new JLabel("사랑합니다");

- 이미지 레이블 생성
    1. 이미지 파일로부터 이미지를 읽기 위해 ImageIcon 클래스 사용
    2. 다룰 수 있는 이미지 : png, gif, jpg

- 수평 정렬 값을 가진 레이블 컴포넌트 생성
    수평 정렬로, 문자열과 이미지를 모두 가진 레이블
연습) LabelEx.java

JButton으로 버튼 만들기
- JButton의 용도
    1. 버튼 모양의 컴포넌트. 사용자로부터 명령을 입력 받기 위한 목적
    2. 버튼은 클릭될 대 Action 이벤트 발생

- 버튼 생성
    1. JButton() 빈 버튼
    2. JButton(Icon image) 이미지 버튼
    3. JButton(String text) 문자열 버튼
    4. JButton(String text, Icon image) 문자열과 이미지 모두 가진 버튼

이미지 버튼 만들기
- 하나의 버튼에 3 개의 이미지 등록
    1. 마우스 조작에 따라 3 개의 이미지 중 적절한 이미지 자동 출력

3개의 버튼 이미지
- normallcon
    1. 버튼의 보통 상태(디폴트) 때 출력되는 이미지
    2. 생성자에 이미지 아이콘 전달 혹은 JButton의 setIcon(normalIcon);
- rollovericon
    1. 버튼에 마우스가 올라갈 때 출력되는 이미지
    2. 이미지 설정 메소드 : JButton의 setRolloverIcon(rolloverIcon);
- pressdicon
    1. 버튼을 누른 상태 때 출력되는 이미지
    2. 이미지 설정 메소드 : JButton의 setPressedIcon(pressedIcon)

JCheckBox로 체크박스 만들기
- JCheckBox의 용도
    선택(selected)과 비선택(deselected) 두 상태만 가지는 버튼

- 체크박스 생성
    1. JCheckBox() 빈 체크박스
    2. JCheckBox(Icon image) 이미지 체크박스
    3. JCheckBox(Icon image, boolean selected) 이미지 체크박스
    4. JcheckBox(String text, Icon image) 문자열과 이미지를 가진 체크박스
    5. JcheckBox(String text, Icon image, boolean selected) 문자열과 이미지 체크박스

연습) CheckBoxEx.java

체크박스에 Item 이벤트 처리
- Item 이벤트
    1. 체크 박스의 선택 상태에 변화가 생길 때 발생하는 이벤트
        - 사용자가 마우스나 키보드로 체크박스를 선택/해체할 때
        - 프로그램에서 체크박스를 선택/해체하여 체크 상태에 변화가 생길 때
    2. 이벤트가 발생하면 itemEvent 객체 생성
    3. itemListener 리스너를 이용하여 이벤트 처리

연습) CheckBoxItemEventEx.java

JRadioButton으로 라디오 버튼 만들기
- JRadioButton의 용도
    1. 버튼 그룹을 형성하고, 그룹에 속한 버튼 중 하나만 선택되는 라디어버튼
    2. 체크박스와 차이점
        체크 박스는 각각 선택/해제가 가능하지만, 라디오버튼은 그룹에 속한 버튼 중 하나만 선택
    
- 라디오버튼 생성
    1. JRadioButton() 빈 라디오버튼
    2. JRadioButton(Icon image) 이미지 라디오버튼
    3. JRadioButton(Icon image, boolean selected) 이미지 라디오버튼
    4. JRadioButton(String text, boolean selected) 문자열 라디오버튼
    5. JRadioButton(String text, Icon image) 문자열과 이미지를 가진 라디오버튼
    6. JRadioButton(String text, Icon image, boolean selected) 문자열과 이미지를 가진 라디오버튼

라디오버튼 생성 및 item 이벤트 처리
- 버튼 그룹과 라디오버튼 생성 과정
    1. 버튼 그룹 객체 생성
    2. 라디오버튼 생성
    3. 라디오버튼 그룹에 삽입
    4. 라디오버튼을 컨테이너에 삽입

- 라디오버튼에 item 이벤트 처리 : itemListener 리스너 이용
    라디오버튼이 선택/해제되어 상태가 달라지면, item 이벤트 발생
        1. 사용자가 마우스나 키보드로선택 상태를 변경할 때
        2. 프로그램에서 JRadioButton의 setSelected()를 호출하여 선택 상태를 변경할 때

연습) RadioButtonEx.java

JTextField로 한 줄 입력 창 만들기
- JTextField
    한 줄의 문자열을 입력 받는 창(텍스트 필드)
    1. 텍스트 입력 동중 <ENTER>키가 입력되면 Action 이벤트 발생
    2. 입력 가능한 문자 개수와 입력 창의 크기는 서로 다름

- 텍스트필드 생성
    1. JTextField() 빈 텍스트 필드
    2. JTextField(int cols) 입력 창의 열의 개수가 cols개인 텍스트필드
    3. JTextField(String text) text 문자열로 초기화된 텍스트필드
    4. JTextField(String text, int cols) 입력 창의 열의 개수는 cols개이고 text 문자열로 초기화된 텍스트필드

연습) TextFieldEx.java

TextArea로 여러 줄의 입력 창 만들기

JTextArea
- 여러 줄의 문자열을 입력받을 수 있는 창(텍스트영역)
    1. 스크롤바를 지원하지 않는다.
    2. JScrollPane 객체에 삽입하여 스크롤바 지원받음

생성자
1. JTextArea() 빈 텍스트영역
2. JTextArea(int rows, int cols) 입력 창이 rows X cols개의 문자 크기인 텍스트영역
3. JTextArea(String text) text 문자열로 초기화된 텍스트영역
4. JTextAtea(String text, int rows, int cols) 입력 창이 rows X cols개의 문자 크기이며 text 문자열로 초기화된 텍스트영역

연습) TextAreaEx.java

- JList <E>
    1. 하나 이상의 아이템을 보여주고 아이템을 선택하도록 하는 리스트
    2. Java 7부터 제네릭 리스트로 바뀜
        <E>에 지정된 타입의 객체만 저장하는 리스트
    3. JScrollPane에 JList<E>를 삽입하여 스크롤 가능

- 리스트 생성
    1. JList<E> 빈 리스트
    2. JList<E> (Vector ListData) 벡터로부터 아이템을 공급받는 리스트
    3. JList<E> (Object [] ListData) 배열로부터 아이템을 공급받는 리스트

연습) ListEx.java

- JComboBox<E>
1. 텍스트필드와 버튼, 그리고 드롭다운 리스트로 구성되는 콤보박스
2. 드롭다운 리스트에서 선택한 것이 텍스트필드에 나타남

- 콤보박스 생성
    1. JComboBox<E>() 빈 콤보박스
    2. JComboBox<E>(Vector ListData) 벡터로부터 아이템을 공급받는 콤보박스
    3. JComboBox<E>(Object [] ListDat) 배열로부터 아이템을 공급받는 콤보박스

연습 ) ComboActionEx.java


메뉴 구성
- 메뉴 만들기에 필요한 스윙 컴포넌트
    1. 메뉴아이템 - JMenuItem
    2. 메뉴 -JMenu
        여러 개의 메뉴 아이템을 가짐
    3. 메뉴바 - JMenuBar
        여러 개의 메뉴를 붙이는 바이며, 프레임에 부착됨
    4. 분리선
        메뉴아이템 사이의 분리선으로 separator라고 부름
        JMenu의 addSeparator()를 호출하여 삽입함

연습 ) MenuEx.java

메뉴아이템에 Action 이벤트 달기
- 메뉴아이템을 클릭하면 Action 발생
    1. 메뉴아이템은 사용자로부터의 지시나 명령을 받는데 사용
    2. ActionListener 인터페이스로 리스너 작성
    3. 각 메뉴아이템마다 이벤트 리스너 설정

연습 ) MenuActionEventEx.java

팝업 다이얼로그, JOptionPane
- 팝업 다디얼로그
    1. 사용자에게 메시지를 전달하거나 문자열을 간단히 입력받는 용도
    2. JOptionPane 클래스를 이용하여 생성
        Static 타입의 간단한 메소드 이용
- 입력 다이얼로그 -JOprionPane.showInputDialog()
    한 줄을 입력 받는 다이얼로그

확인 다이얼로그 -JOptionPane.showConfirmDialog()
    사용자로부터 Yes/No 응답을 입력 받는 다이얼로그

메시지 다이얼로그 -showMessageDialog
    단순 메시지를 출력하는 다이얼로그

연습 ) OptionPaneEx.java










## 5월 24일 강의
이벤트 기반 프로그래밍
- 이벤트의 발생에 의해 프로그램 흐름이 결정되는 방식
    1. 이벤트가 발생하면 이벤트를 처리하는 루틴(이벤트 리스너) 실행
    2. 실행될 코드는 이벤트의 발생에 의해 전적으로 결정

- 반대되는 개념 : 배치 실행(batch programming)
    1. 프로그램의 개발자가 프로그램의 흐름을 결정하는 방식

- 이벤트 종류
    1. 사용자의 입력 : 마우스 드래그, 마우스 클릭, 키보드 누름 등
    2. 센서로부터의 입력, 네트워크로부터 데이터 송수신
    3. 다른 응용프로그램이나 다른 스레드로부터의 메시지

- 이벤트 기반 응용 프로그램의 구조
    1. 각 이벤트마다 처리하는 리스너 코드 보유

- GUI 응용프로그램은 이벤트 기반 프로그래밍으로 작성됨
    1. GUI 라이브러리 종류
        - C++ 의 MFC, C# GUI, Visual Basic, X Window, Android 등
        - 자바의 AWT와Swing

자바 스윙 프로그램에서 이벤트 처리 과정
 - 이벤트 발생
    예) 마우스의 움직임 혹은 키보드입력
- 이벤트 객체 생성
    현재 발생한 이벤트에 대한 정보를 가진 객체
- 응용프로그램에 작성된 이벤트 리스너 찾기
- 이벤트 리스너 실행
    1. 리스너에 이벤트 객체 전달
    2. 리스너 코드 실행

이벤트 객체
    발생한 이벤트에 관한 정보를 가진 객체
    이벤트 리스너에 전달됨
        이벤트 리스너 코드가 발생한 이벤트에 대한 상황을 파악할 수 있게 함

- 이벤트 객체가 포함하는 정보
    1. 이벤트 종류와 이벤트 소스
    2. 이벤트가 발생한 화면 좌표 및 컴포넌트 내 좌표
    3. 이벤트가 발생한 버튼이나 메뉴 아이템의 문자열
    4. 클릭된 마우스 버튼 번호 및 마우스의 클릭 횟수
    5. 키의 코드 값과 문자 값
    6. 체크박스, 라디오버튼 등과 같은 컴포넌트에 이벤트가 발생하였다면 체크 상태

- 이벤트 소스를 알아 내는 메소드
    Object getSource()
    1. 발생한 이벤트의 소스 컴포넌트 리턴
    2. Object 타입으로 리턴하므로 캐스팅하여 사용
    3. 모든 이벤트 객체에 대해 적용


리스너 인터페이스
- 이벤트 리스너
    1. 이벤트를 처리하는 자바 프로그램 코드, 클래스로 작성

- 자바는 다양한 리스너 인터페이스 제공
    예) ActionListener 인터페이스 - 버튼 클릭 이벤트를 처리하기 위한 인터페이스
        interface ActionListener { // 아래 메소드를 개발자가 구현해야 함
            public void actionPerformed(ActionEvent e); // Action 이벤트 발생시 호출됨
    
    예) MouseListener 인터페이스– 마우스 조작에 따른 이벤트를 처리하기위한인터페이스
        interface MouseListener { // 아래의 5개 메소드를 개발자가 구현해야 함
            public void mousePressed(MouseEvent e); // 마우스 버튼이 눌러지는 순간 호출
            public void mouseReleased(MouseEvent e); // 눌러진  마우스 버튼이 떼어지는 순간 호출
            public void mouseClicked(MouseEvent e); // 마우스가 클릭되는 순간 호출
            public void mouseEntered(MouseEvent e); // 마우스가 컴포넌트 위에 올라가는 순간 호출
            public void mouseExited(MouseEvent e); // 마우스가 컴포넌트 위에서 내려오는 순간 호출

- 사용자의 이벤트 리스너 작성
    1. 자바의 리스너 인터페이스 (interface)를 상속받아 구현
    2. 리스너 인터페이스의 모든 추상 메소드 구현


이벤트 리스너 작성 과정 사례

1. 이벤트와 이벤트 리스너 선택
    - 버튼 클릭을 처리하고자 하는 경우
        이벤트 : Action 이벤트, 이벤트 리스너 : ActionListener

2. 이벤트 리스너 클래스 작성 : ActionListener 인터페이스 구현

3. 이벤트 리스너 등록
    - 이벤트를 받아 처리하고자 하는 컴포넌트에 이벤트 리스너 등록
    - component.addXXXListener(listener)
        xxx: 이벤트 명, listener: 이벤트 리스너 객체
            MyActionListener listener = new MyActionListener(); // 리스너 인스턴스 생성
            btn.addActionListener(listener); // 리스너 등록

이벤트 리스너 작성 방법    
(3 가지 방법)

- 독립 클래스로 작성
    1. 이벤트 리스너를 완전한 클래스로 작성
    2. 이벤트 리스너를 여러 곳에서 사용할 때 적합
- 내부 클래스(inner class)로 작성
    1. 클래스 안에 멤버처럼 클래스 작성
    2. 이벤트 리스너를 특정 클래스에서만 사용할 때 적합
- 익명 클래스(anonymous class)로 작성
    1. 클래스의 이름 없이 간단히 리스너 작성
    2. 클래스 조차 만들 필요 없이 리스너 코드가 간단한 경우에 적합

연습) IndepClassListener.java

어댑터 클래스
- 이벤트 리스너 구현에 따른 부담
    1. 리스너의 추상 메소드를 모두 구현해야 하는 부담
    2. 예) 마우스 리스너에서 마우스가 눌러지는 경우(mousePressed())만 처리하고자 하는 경우에도 나머지 4 개의 메소드를 모두 구현해야 하는 부담

- 어댑터 클래스(adapter)
    1. 리스너의 모든 메소드를 단순 리턴하도록 만든 클래스(JDK에서 제공)
    2. 추상 메소드가 하나뿐인 리스너는 어댑터 없음

Key 이벤트와 포커스
- 키 입력 시, 다음 세 경우 각각 key 이벤트 발생
    1. 키를 누르는 순간
    2. 누른 키를 떼는 순간
    3. 누른 키를 떼는 순간(unicode 키의 경우에만)

- 키 이벤트를 받을 수 있는 조건
    1. 모든 컴포넌트
    2. 현재 포커스(foucs)를 가진 컴포넌트가 키 이벤트 독점

- 포커스(focus)
    1. 컴포넌트나 응용프로그램이 키 이벤트를 독점하는 권한
    2. 컴포넌트에 포커스 설정 방법 : 다음 2 라인 코드 필요


유니코드(unicode) 키의 특징
1. 국제 산업 표준
2. 전 세계의 문자를 컴퓨터에서 일관되게 표현하기 위한 코드 체계
3. 문자들에 대해서만 키 코드 값 정의
    A~Z, a~z, 0~9, !, @, & 등
4. 문자가 아닌 키 경우에는 표준화된 키 코드 값 없음
    <Function> 키, <Home> 키, <Up> 키, <Delete> 키, <Control> 키, <Shift> 키, <Alt> 등은 플랫폼에 따라 키 코드 값이 다를 수 있음

유니코드 키가 입력 되는 경우
- keyPressed(), keyTyped(), keyReleased()가 순서대로 호출
유니코드 키가 아닌 경우
- keyPressed(), keyReleased() 만 호출됨


가상 키와 입력된 키 판별
- keyEvent 객체
    1. 입력된 키 정보를 가진 이벤트 객체
    2. KeyEvent 객체의 메소드로 입력된 키 판별

- KeyEvent 객체의 메소드로 입력된 키 판별
    char KeyEvent.getKeychar()
    1. 키의 유니코드 문자 값 리턴
    2. Unicode 문자 키인 경우에만 의미 있음
    3. 입력된 키를 판별하기 위해 문자 값과 비교하면 됨

- int KeyEvent.getKeyCode()
    1. 유니코드 키 포함
    2. 모든 키에 대한 정수형 키 코드 리턴
    3. 입력된 키를 판별하기 위해 가상키(Virtual Key) 값과 비교하여야 함
    4. 가상 키 값은 KeyEvent 클래스에 상수로 선언


마우스 리스너 달기
- 마우스 리스너는 컴포넌트에 다음과 같이 등록
    component.addMouseListener(myMouseListener);
- 컴포넌트가 마우스(mouseMoved())나 마우스 드래깅(mouseDraggecd())을 함께 처리하고자 하면, MouseMotion 리스너 따로 등록
    component.addMouseMotionListener(myMouseMotionListener);

- MouseEvent 객체 활용
    1. 마우스 포인터의 위치, 컴포넌트 내 상대 위치 int getX(), int getY()
    2. 마우스 클릭 횟수 int getClickCount()






    



## 5월 17일 강의
- 컨테이너와 배치, 배치관리자 개념
    1. 컨테이너마다 하나의 배치관리자 존재
    2. 컨테이너에 부착되는 컴포넌트의 위치와 크기 결정
    3. 컨테이너의 크기가 변경되면, 컴포넌트의 위치와 크기 재결정

- 배치 관리자 대표 유형 4가지
    1. FlowLayout 배치관리자
        - 컴포넌트가 삽입되는 순서대로 왼쪽에서 오른쪽으로 배치
        - 배치할 공간이 없으면 아래로 내려와서 반복한다.
    2. BorderLayout 배치관리자
        - 컨테이너의 공간을 동(EAST), 서(WEST), 남(SOUTH), 북(NORTH), 중앙(CENTER)의 5개 영역으로 나눔
        - 5개 영역 중 응용프로그램에서 지정한 영역에 컴포넌트 배치
    3. GridLayout 배치관리자
        - 컨테이너를 프로그램에서 설정한 동일한 크기의 2차원 격자로 나눔
        - 컴포넌트는 삽입 순서대로 좌에서 우로, 다시 위에서 아래로 배치
    4. CardLayout
        - 컨테이너의 공간에 카드를 쌓아 놓은 듯이 컴포넌트를 포개어 배치

- 컨테이너에 새로운 배치관리자 설정
    1. setLayout(LayoutManager Im) 메소드 호출
        - Im을 새로운 배치관리자로 설정
    2. 사례
        - JPanel 컨테이너에 BorderLayout 배치관리자를 설정하는 예
            JPanel p = new Jpanel();
            p.setLayout(new BorderLayout()); // JPanel에 BorderLayout 설정
        
        - 컨텐트팬의 배치관리자를 FlowLayout 배치관리자로 설정
            Container c - frame.getConentPane(); // 프레임의 컨텐트팬 알아내기

            c.setLayout(new FlowLayout()); // 컨텐트팬에 FlowLayout 설정

        - 오류
            c.setLayout(FlowLayout); // 오류
    
- FlowLayout 배치관리자
    1. 배치방법
        - 컴포넌트를 컨테이너 내에 왼쪽에서 오른쪽으로 배치
            다시 위에서 아래로 순서대로 배치
                container.setLayout(new FlowLayout());
                container.add(new JButton("add"));
                container.add(new JButton("sub"));
                container.add(new JButton("mul"));
                container.add(new JButton("div"));
                container.add(new JButton("Calculate"));

- FlowLayout의 생성자
    1. 생성자
        - FlowLayout()
        - FlowLayout(int align, int hGap, int vGap)
            1. align : 컴포넌트를 정렬하는 방법 지정. 왼쪽 정렬(FlowLayout.LEFT), 오른쪽 정렬(FlowLayout.RIGHT), 중앙 정렬(FlowLayout.CENTER(디폴트))
            2. hGap : 좌우 두 컴포넌트사이의수평간격, 픽셀단위. 디폴트는 5
            3. vGap : 상하 두 컴포넌트사이의수직간격, 픽셀단위. 디폴트는 5

연습) FlowLayoutEx.java

- BorderLayout 배치관리자
    1. 배치방법
        - 컨테이너 공간을 5 구역으로 분할, 배치 (동, 서, 남, 북, 중앙)
        - 배치 방법 add(Component comp, int index)
    
- BorderLayout 생성자와 add() 메소드
    1. 생성자
        - BorderLayout()
        - BorderLayout(int hGap, int vGap)
            hGap : 좌우 두 컴포넌트 사이의 수평 간격, 픽셀 단위(디폴트 : 0)
            vGap : 상하 두 컴포넌트 사이의 수직 간격, 픽셀 단위(디폴트 : 0)
    
    2. add() 메소드
        - void add(Component comp, int index)
            comp 컴포넌트를 index 위치에 삽입한다.
            index : 컴포넌트의 위치
                동 : BorderLayout.EAST
                서 : BorderLayout.WEST
                남 : BorderLayout.SOUTH
                북 : BorderLayout.NORTH
                중앙 : BorderLayout.CENTER
    
연습) BorderLayOutEx.java

- GridLayout 배치관리자
    1. 배치방법
        - 컨테이너 공간을 동일한 사각형 격자(그리드)로 분할하고 각 셀에 컴포넌트 하나씩 배치
            생성자에 행수와 열수 지정
            셀에 왼쪽에서 오른쪽으로, 다시 위에서 아래로 순서대로 배치

- GridLayout 생성자
    1. 생성자
        - GridLayout()
        - GridLayout(int rows, int cols)
        - GridLayout(int rows, int cols, int hGap, int vGap)
            rows : 격자의 행수 (디폴트 : 1)
            cols : 격자의 열수 (디폴트 : 1)
            hGap : 좌우 두 컴포넌트 사이의 수평 간격, 픽셀 단위(디폴트 : 0)
            vGap : 상하 두 컴포넌트 사이의 수직 간격, 픽셀 단위(디폴트 : 0)
            rows x cols 만큼의 셀을 가진 격자로 컨테이너 공간을 분할, 배치

연습) GridLayoutEX.java


- 배치관리자가 없는 컨테이너가 필요한 경우
    응용프로그램에서 직접 컴포넌트의 크기와 위치를 결정하고자 하는 경우
    1. 컴토넌트의 크기나 위치를 개발자 임의로 결정하고자 하는 경우
    2. 게임 프로그램과 같이 시간이나 마우스/키보드의 입력에 따라 컴포넌트들의 위치와 크기가 수시로 변하는 경우
    3. 여러 컴포넌트들이 서로 겹쳐 출력하고자 하는 경우

- 컨테이너 배치 관리자 제거 방법
    1. container.setLayout(null);
    2. 컨테이너의 배치관리자가 없어지면, 컴포넌트에 대한 어떤 배치도 없음


- 컴포넌트의 절대 위치와 크기 설정
    1. 배치관리자 없는 컨테이너에 컴포넌트를 삽입할 때
        프로그램에서 컴포넌트의 절대 크기와 위치 설정
        컴포넌트들이 서로 겹치게 할 수 있음
    
    2. 컴포넌트의 크기와 위치 설정 메소드
        - void setSize(int width, int height) // 컴포넌트 크기 설정
        - void setLoaction(int x, int y) // 컴포넌트 위치 설정
        - void setBounds(int x, int y, int width, int height) // 위치와 크기 동시 설정

연습) NullContainerEx.java


## 5월 3일 강의

- 컬렉션(collection)의 개념
1. 요소(element)라고 불리는 가변 개수의 객체들의 저장소
    - 객체들의 컨테이너라고도 불림
    - 요소의 개수에 따라 크기 자동 조절
    - 요소의 삽입, 삭제에 따른 요소의 위치 자동 이동
2. 고정 크기의 배열을 다루는 어려움 해소
3. 다양한 객체들의 삽입, 삭제, 검색 등의 관리 용이

- 컬렉션의 특징
1. 컬렉션은 제네릭(generics) 기법으로 구현
    제네릭
        - 특정 타입만 다루지 않고, 여러 종류의 타입으로 변신할 수 있도록 클래스나 메소드를 일반화시키는 기법
        - 클래스나 인터페이스 이름에 <E>,<K>,<V> 등 타입매개변수 포함
    제네릭 컬렉션 사례 : 벡터 Vector<E>
        - <E>에서 E에 구체적인 타입을 주어 구체적인 타입만 다루는 벡터로 활용
        - 정수만 다루는 컬렉션 벡터 Vector<Integer>
        - 문자열만 다루는 컬렉션 벡터 Vector<String>
2. 컬렉션의 요소는 객체만 가능
    - int, char, double 등의 기본 타입으로 구체화 불가


- 제네릭은 형판과 같은 개념
    클래스나 메소드를 형판에서 찍어내듯이 생산할 수 있도록 일반화된 형판을 만드는 기법

- 벡터 Vector<E>의 특성
    1. <E>에 사용할 요소의 특정 타입으로 구체화
    2. 배열을 가변 크기로 다룰 수 있게 하는 컨테이너
        - 배열의 길이 제한 극복
        - 요소의 개수가 넘치면 자동으로 길이 조절
    3. 요소 객체들을 삽입, 삭제, 검색하는 컨테이너
        - 삽입, 삭제에 따라 자동으로 요소의 위치 조정
    4. Vector에 삽입 가능한 것
        - 객체, null
        - 기본 타입의 값은 Wrapper 객체로 만들어 저장
    5. Vector에 객체 삽입
        - 벡터의 맨 뒤, 중간에 객체 삽입 가능
    6. Vector에서 객체 삭제
        - 임의의 위치에 있는 객체 삭제 기능
    

ArrayList<E>
1. 가변 크기 배열을 구현한 클래스
    - <E>에 요소로 사용할 특정 타입으로 구체화
2. 벡터와 거의 동일
    - 요소 삽입, 삭제, 검색 등 벡터 기능과 거의 동일
    - 벡터와 달리 스레드 동기화 기능 없음

컬렉션의 순차 검색을 위한 Iterator
1. Iterator<E> 인터페이스
    - 리스트 구조의 컬렉션에서 요소의 순차 검색을 위한 인터페이스
        Vector<E>, ArrayList<E>, LinkedList<E>가 상속받는 인터페이스
2. Iterator 객체 얻어내기
    - 컬렉션의 iterator() 메소드 호출
        해당 컬렉션을 순차 검색할 수 있는 Iterator 객체 리턴
    - 컬렉션 검색 코드

HashMap<K,V>
1. 키(key)와 값(vaule)의 쌍으로 구성되는 요소를 다루는 컬렉션
    - K : 키로 사용할 요소의 타입
    - V : 값으로 사용할 요소의 타입
    - 키와 값이 한 쌍으로 삽입
    - '값'을 검색하기 위해서는 반드시 '키' 이용
2. 삽입 및 검색이 빠른 특징
    - 요소 삽입 : put() 메소드
    - 요소 검색 : get() 메소드

제네릭 만들기
- 제네릭 클래스 작성
    클래스 이름 옆에 일반화 된 타입 매개 변수 추가
- 제네릭 객체 생성 및 활용
    제네릭 타입에 구체적인 타입을 지정하여 객체를 생성하는 것을 구체화라고 함

자바의 GUI
- GUI 응용프로그램
    GUI
    1. 사용자가 편리하게 입출력 할 수 있도록 그래픽으로 화면을 구성하고, 마우스나 키보드로 입력 받을 수 있도록 지원하는 사용자 인터페이스

    자바 언어에서 GUI 응용프로그램 작성
    1. AWT와 Swing 패키지에 강력한 GUI 컴포넌트 제공
    2. 쉬운 GUI 프로그래밍

- AWT와 Swing 패키지
    AWT 패키지
    1. 자바가 처음 나왔을 때 부터 배포된 GUI패키지, 최근에는 거의 사용하지 않음
    2. AWT 컴포넌트는 중량 컴포넌트
        - AWT 컴포넌트의 그리기는 운영체제에 의해 이루어지며, 운영체제에 의 자원을 많이 소모하고 부담을 줌
        - 운영체제가 직접 그리기 때문에 속도는 빠름
    
- Swing 패키지
1. AWT 기술을 기반으로 작성된 자바 라이브러리
2. 모든 AWT 기능 + 추가된 풍부하고 화려한 고급 컴퍼넌트
3. AWT 컴포넌트를 모두 스윙으로 재작성. AWT 컴포넌트 이름 앞에 J자를 덧붙임
4. 순수 자바 언어로 구현
5. 스윙 컴포넌트는 경량 컴포넌트
    스윙 컴포넌트는 운영체제의 도움을 받지 않고 직접 그리기 때문에 운영체제에 부담주지 않음
6. 현재 자바의 GUI로 사용됨

컨테이너와 컴포넌트
- 컨테이너
    1. 다른 컴포넌트를 포함할 수 있는 GUI 컴포넌트
        java.awt.Container를 상속받음
    2. 다른 컨테이너에 포함될 수 있음
        AWT 컨테이너: Panel, Frame, Applet, Dialog, Window
        Swing 컨테이너: JPanel JFrame, JApplet, JDialog, JWingdow

- 컴포넌트
    1. 컨테이너에 포함되어야 화면에 출력될 수 있는 GUI 객체
    2. 다른 컴포넌트를 포함할 수 없는 순수 컴포넌트
    3. 모든 GUI 컴포넌트가 상속받는 클래스 : java.awt.Compnent
    4. 스윙 컴포넌트가 상속받는 클래스 : javax.swing.JComponent

- 최상위 컨테이너
    1. 다른 컨테이너에 포함되지 않고도 화면에 출력되며 독립적으로 존재 가능한 컨테이너
        스스로 화면에 자신을 출력하는 컨테이너 : JFrame, JDialog, JApplet

스윙 GUI 프로그램 만들기
- 스윙 GUI 프로그램을 만드는 과정
    1. 스윙 프레임 만들기
    2. main() 메소드 작성
    3. 스윙 프레임에 스윙 컴포넌트 붙이기

- 스윙 프로그램 작성에 필요한 import문
    1. import java.awt.*; // 그래픽 처리를 위한 클래스들의 경로명
    2. import java.awt.event.*; // AWT 이벤트 사용을 위한 경로명
    3. import javax.swing.*; // 스윙 컴포넌트 클래스들의 경로명
    4. import javax.swing.event.*; // 스윙 이벤트를 위한 경로명

스윙 프레임이란
모든 스윙 컴포넌트를 담는 최상위 컨테이너
    1. JFrame을 상속받아 구현
    2. 컴포넌트들은 화면에 보이려면 스윙 프레임에 부착되어야 함
        프레임을 닫으면 프레임에 부착된 모든 컴포넌트가 보이지 않게 됨
스윙 프레임(JFrame)기본 구성
    1. 프레임-스윙 프로그램의 기본 틀
    2. 메뉴바-메뉴들이 부착되는 공간
    3. 컨텐트팬-GUI 컴포넌트들이 부착되는 공간

프레임 만들기, JFrame 클래스 상속
스윙 프레임
    1. JFrame 클래스를 상속받은 클래스 작성
    2. 프레임의 크기 반드시 지정 : setSize() 호출
    3. 프레임을 화면에 출력하는 코드 반드시 필요 : setVusubke(true)호출

스윙 응용프로그램에서 main()의 기능과 위치
- 스윙 응용프로그램에서 main()의 기능 최소화 바람직
    1. 스윙 응용프로그램이 실행되는 시작점으로서의 기능만
    2. 스윙 프레임을 생성하는 정도의 코드로 최소화
        public static void main(String [] arg){
            MyFrame frame = new MyFrame(); // 스윙프레임 생성
        }

프레임에 컴포넌트 붙이기
- 타이틀 달기
     super()나 setTitle() 이용
- 컨텐트팬에 컴포넌트 달기
    1. 컨텐트팬이란?
        스윙 컴포넌트들이 부착되는 공간
    2. 컨텐트팬 알아내기
        스윙 프레임에 붙은 디폴트 컨텐트팬 알아내기
    3. 컨텐트팬에 컴포넌트 붙이기
    4. 컨텐트팬 변경


## 4월 19일 강의

추상 클래스
- 추상 메소드(abstract method)
    abstract로 선언된 메소드, 메소드의 코드는 없고 원형만 선언
    abstract public String getName(); // 추상 메소드
    abstract public String fail() { return "Good Bye";} // 추상 메소드 아님. 컴파일 오류

- 추상 클래스(abstract class)
    추상 메소드를 가지며, abstract로 선언된 클래스
    추상 메소드 없이, abstract로 선언한 클래스
// 추상 메소드를 가진 추상 클래스
    abstract class Shape {
        public Shape() {}
        public void edit() {}

        abstract public void draw();// 추상 메소드
    }

// 추상 메소드 없는 추상 클래스
    abstract class JComponent {
        String name;
        public void load(String name) {
            this.name=name;
        }
    }

    class fault { //오류. 추상 메소드를 가지고 있으므로 abstract로 선언되어야 함
        abstract public void f(); // 추상 메소드
    }

추상 클래스의 인스턴스 생성 불가
- 추상 클래스는 온전한 클래스가 아니기 때문에 인스턴스를 생성할 수 없음

    JComponent p; //오류 없음. 추상 클래스의 레퍼런스 선언
    p = new JComponent(); // 컴파일 오류. 추상 클래스의 인스턴스 생성 불가
    shape obj = new Shape(); // 컴파일 오류. 추상 클래스의 인스턴스 생성 불가

추상 클래스의 상속과 구현
- 추상 클래스 상속
    1. 추상 클래스를 상속받으면 추상 클래스가 됨
    2. 서브 클래스도 abstract로 선언해야 함

- 추상 클래스 구현
    1. 서브 클래스에서 슈퍼 클래스의 추상 메소드 구현(오버라이딩)
    2. 추상 클래스를 구현한 서브 클래스는 추상 클래스 아님

추상 클래스의 목적
- 상속을 위한 슈퍼 클래스로 활용하는 것
- 서브 클래스에서 추상 메소드 구현
- 다형성 실현

자바의 인터페이스
- 클래스가 구현해야 할 메소드들이 선언되는 추상형
- 인터페이스 선언
    1. interface 키워드로 선언
    2. Ex) public interface SerialDriver {}

자바 인터페이스에 대한 변화
 - java 7까지
    1. 인터페이스는 상수와 추상 메소드로만 구성
- java 8부터
    1. 상수와 추상메소드 포함
    2. default 메소드 포함 (java 8)
    3. private 메소드 포함 (java 9)
    4. static 메소드 포함 (java 9)
- 여전히 인터페이스에는 필드(멤버 변수) 선언 불가

인터페이스의 구성 요소들의 특징
- 상수
    1. public만 허용, public static final 생략
- 추상 메소드
    1. public abstract 생략 가능
- default 메소드
    1. 인터페이스에 코드가 작성된 메소드
    2. 인터페이스를 구현하는 클래스에 자동 상속
    3. public 접근 지정만 허용. 생략 가능
- private 메소드
    1. 인터페이스 내에 메소드 코드가 작성되어야 함
    2. 인터페이스 내에 있는 다른 메소드에 의해서만 호출 가능
- static 메소드
    1. public, private 모두 지정 가능. 생락하면 public

자바 인터페이스 특징
- 인터페이스의 객체 생성 불가
    new PhonoeInterface(); // 오류. 인터페이스 PhoneInterface 객체 생성 불가
- 인터페이스 타입의 레퍼런스 변수 선언 가능
    phoneInterface galaxy; // galaxy는 인터페이스에 대한 레퍼런스 변수

인터페이스 상속
- 인터페이스 간에 상속 가능
    1. 인터페이스를 상속하여 확장된 인터페이스 작성 가능
    2. extends 키워드로 상속 선언
- 인터페이스 다중 상속 허용

인터페이스 구현
- 인터페이스의 추상 메소드를 구현한 클래스 작성
    1. implements 키워드 사용
    2. 여러 개의 인터페이스 동시 구현 가능

자바의 패키지와 모듈이란?
- 패키지(package)
    1. 서로 관련된 클래스와 인터페이스를 컴파일한 클래스 파일들을 묶어 놓은 디렉터리
    2. 하나의 응용프로그램은 한 개 이상의 패키지로 작성
    3. 패키지는 jar 파일로 압축할 수 있음
- 모듈(module)
    1. 여러 패키지와 이미지 등의 자원을 모아 놓은 컨테이너
    2. 하나의 모듈을 하나의 .jmod 파일에 저장
- java 9부터 모듈화 도입
    1. java 9부터 자바 API의 모든 클래스들(자바 실행 환경)을 패키지 기반에서 모듈들로 완전히 재구성
- 응용프로그램의 모듈화
    1. 클래스들은 패키지로 만들고, 다시 패키지를 모듈로 만듦
    2. 모듈 프로그래밍은 어렵고 복잡. 기존 방식으로 프로그램 작성

- 모듈화의 목적
    1. java 9부터 자바 API를 여러 모듈(99개)로 분할
        java 8까지는 rt.jar의 한 파일에 모든 API 저장
    2. 응용프로그램이 실행할 때 꼭 필요한 모듈들로만 실행 환경 구축
        메모리 자원이 열악한 작은 소형 기기에 꼭 필요한 모듈로 구성된 작은 크기의 실행 이미지를 만들기 위함
- 모듈의 현실
    1. java 9부터 전면적으로 도입
    2. 복잡한 개념
    3. 큰 자바 응용프로그램에는 개발, 유지보수 등에 적합
    4. 현실적으로 모듈로 나누어 자바 프로그램을 작성할 필요 없음

자바 API의 모듈 파일들
- 자바 JDK에 제공되는 모듈 파일들
    자바가 설치된 jmods 디렉터리에 모듈 파일 존재
    1. .jmod 확장자를 가진 파일
    2. jdk 10의 경우 99개 모듈 파일
    3. 모듈 파일은 ZIP 포맷으로 압축된 파일
- 모듈 파일에는 자바 API의 패키지와 클래스들이 들어 있음
- jmod 명령을 이용하여 모듈 파일에 들어 있는 패키지를 풀어 낼 수 있음

패키지 사용하기, import문
- 다른 패키지에 작성된 클래스 사용
    1. import를 이용하지 않는 경우
    2. 필요한 클래스만 import
    3. 패키지 전체를 import

패키지 만들기
- 클래스 파일(.class)이 저장되는 위치는?
    1. 클래스나 인터페이스가 컴파일되면 클래스 파일(.class) 생성
    2. 클래스 파일은 패키지로 선언된 디렉터리에 저장
- 패키지 선언
    1. 소스 파일의 맨 앞에 컴파일 후 저장될 패키지 지정

디폴트 패키지 
- package 선언문이 없는 자바 소스 파일의 경우
    1. 컴파일러는 클래스나 인터페이스를 디폴트 패키지에 소속시킴
    2. 디폴트 패키지 (현재 디렉터리)

- 모듈
    1. java 9에서 도입된 개념
    2. 패키지와 이미지 등의 리소스를 담은 컨테이너
    3. 모듈 파일(.jmod)로 저장

자바 플랫폼
- 자바의 개발 환경(JDK)과 자바의 실행 환경(JRE)을 지칭
- 자바 API의 모든 클래스가 여러 개의 모듈로 재구성됨
- 모듈 파일은 JDK의 jmods 디렉터리에 저장하여 배포

자바 모듈화의 목적
- 가장 큰 목적
    1. 자바 컴포넌트들을 필요에 따라 조립하여 사용하기 위함
    2. 컴퓨터 시스템의 불필요한 부담 감소
        세밀한 모듈화를 통해 필요 없는 모듈이 로드되지 않게 함
        소형Iot 장치에도 자바 응용프로그램이 실행되고 성능을 유지하게 함

Object 클래스 특징
- 모든 자바 클래스는 반드시 Object를 상속받도록 자동 컴파일
    1. 모든 클래스의 수퍼 클래스
    2. 모든 클래스가 상속받는 공통 메소드 포함

객체 속성
- Object 클래스는 객체의 속성을 나타내는 메소드 제공
    1. hashCode() 메소드
        객체의 해시코드 값을 리턴하며, 객체마다 다름
    2. getClass() 메소드
        객체의 클래스 정보를 담은 Class 객체 리턴
         Class 객체의 getName() 메소드는 객체의 클래스 이름 리턴
    3. toString() 메소드
        객체를 문자열로 리턴

toString() 메소드, 객체를 문자열로 변환
- 각 클래스는 toString()을 오버라이딩항 자신만의 문자열 리턴 가능
    1. 객체를 문자열로 반환
    2. 원형 public String toString();
- 컴파일러에 의한 toString() 자동 변환
    1. '객체 + 문자열' -> '객체.toString() + 문자열'로 자동 변환
    2. 객체를 단독으로 사용 하는 경우 -> 객체.toString()으로 자동변환

Wrapper 클래스
- 자바의 기본 타입을 클래스화한 8개 클래스를 통칭
    기본타입: byte, short, int, long, char, float, double, boolean
    wrapper 클래스: byte, short, Integer, Long, Character, Float, Double, Boolean
용도
- 객체만 사용할 수 있는 컬렉션 등에 기본 타입의 값을 사용하기 위해 -> Wrapper 객체로 만들어 사용

박싱과 언박싱
- 박싱(boxing)
    기본 타입의 값을 Wrapper 객체로 변환하는 것
- 언박싱(unboxing)
    Wrapper 객체에 들어 있는 기본 타입의 값을 빼내는 것
    박싱의 반대
- 자동 박싱과 자동 언박싱
    JDK 1.5부터 박싱과 언박싱은 자동으로 이루어지도록 컴파일 됨

String의 생성과 특징
- String
    1. String 클래스는 문자열을 나타냄
    2. 스트링 리터럴(문자열 리터럴)은 String 객체로 처리됨
    3. 스트링 객체의 생성 사례
        String str1 = "abcd";

        char data[] = "{'a','b','c','d'};
        String str2 = new String(data);
        String str3 = new String("abcd"); // str2와 str3은 모두 "abcd" 스트링

스트링 리터럴과 new String()
- 스트링 리터럴
    1. 자바 가상 기계 내부에서 리터럴 테이블에 저장되고 관리됨
    2. 응용프로그램에서 공유됨 
        스트링 리터럴 사례) String s = "Hello";
- new String()으로 생성된 스트링
    1. 스트링 객체는 힙에 생성
    2. 스트링은 공유되지 않음

스트링 객체의 주요 특징
- 스트링 객체는 수정 불가능
    1. 리터럴 스트링이든 new String()을 생성했든 객체의 문자열 수정 불가능
        String s = enw String("Hello"); // s의 스트링은 수정 불가능
        String t = s.concat("java"); // 스트링 s에 "java"를 덧붙인 스트링 리턴
- 스트링 비교
    1. 두 스트링을 비교할 때 반드시 equals()를 사용하여야 함
        equals()는 내용을 비교하기 때문

String 활용
- 스트링 비교, equals()와 compareTo()
    1. 스트링 비교에 == 연산자 절대 사용 금지
    2. equals() 스트링이 같으면 true, 아니면 false 리턴
    3. int compareTo(String anotherString)
        문자열이 같으면 0리턴
        이 문자열이 anotherString 보다 사전에 먼저 나오면 음수 리턴
        이 문자열이 anotherString 보다 사전에 나중에 나오면 양수 리턴
    4. 공백 제거, String trim()
        키보드나 파일로부터 스트링을 입력 시, 스트링 앞 뒤 공백이 끼는 경우가 많다. -> trim()을 이용하면 스트링 앞 뒤에 있는 공백 제거

StringBuffer 클래스
- 가변 스트링을 다루는 클래스
- StringBuffer 객체 생성
    StringBuffer sb = new StringBuffer("java");
- string 클래스와 달리 문자열 변경 가능
    1. 가변 크기의 버퍼를 가지고 있어 문자열 수정 가능
    2. 문자열의 수정이 많은 작업에 적합

StringTokenzier 클래스
- 구분 문자를 기준으로 문자열을 분리하는 클래스
    1. 구분 문자(delimiter): 문자열을 구분할 때 사용되는 문자
    2. 토큰(token): 구분 문자로 분리된 문자열

Math 클래스
- 기본 산술 연산 메소드를 제공하는 클래스
- 모든 메소드는 static으로 선언
    클래스 이름으로 호출 가능
- Math.random() 메소드로 난수 발생
    random()은 0보다 크거나 같고 1.0보다 작은 실수 난수 발생
    1에서 100까지의 랜덤 정수 10개를 발생시키는 코드 사례



## 4월 12일 강의
static 멤버
- 클래스의 멤버들 중 다음과 같이 static 지시어로 선언된 멤버를 static 멤버라고 부른다.
- static으로 선언된 멤버는 non-static 멤버와 매우 다른 특성을 가진다.
- static 멤버는 클래스당 하나만 생성되는 멤버로서, 동일한 클래스의 모든 객체들이 공유하므로 클래스 멤버라고 부른다.
- non-static 멤버는 각 객체마다 별도로 생기므로 인스턴스 멤버라고 부른다.
- non-static 멤버는 객체가 생길 때 함께 생성되고 객체가 사라지면 함께 사라진다 그러나 static 멤버는 프로그램을 시작할 때나 클래스 로딩 시에 생성된다.
- 객체를 생성하기 전에도 static 멤버는 사용
- 생성된 객체가 소멸된 후에도 static 멤버는 여전히 살아 공간을 차지하고 있으며, 프로그램이 종료할 때 함께 소멸

static 멤버 사용
non-static 멤버가 객체 이름으로만 활용할 수 있는 것과는 달리, static 멤버는 객체 이름이나 클래스 이름으로 모두 활용할 수 있다.
    StaticSample.m =3; // 클래스 이름으로 static 필드 접근
    StaticSample.f(); // 클래스 이름으로 static 메소드 호출
연습) EX4_11.java

static 메소드의 제약 조건
static 메소드는 두 개의 제약 사항을 가진다.

- static 메소드는 오직 static 멤버만 접근할 수 있다.
static 메소드는 객체가 생성되지 않은 상황에서도 사용이 가능하므로 객체에 속한 인스턴스 메소드, 인스턴스 변수 등을 사용할 수 없고, static 멤버들만 사용 가능하다.
인스턴스 메소드는 static 멤버들을 사용할 수 있다.

- static 메소드에서는 this를 사용할 수 없다.
static 메소드는 객체 없이도 존재하기 때문에, static 메소드에서 this를 사용할 수 없다.
    오류 static voidf() { this.n = x;} //오류. static 메소드에서는 this 사용 불가능
    오류 statuc voidg() { this.m = x;} //오류. static 메소드에서는 this 사용 불가능

final 클래스
final 크래스 이름 앞에 사용되면 클래스를 상속받을 수 없음을 지정한다.

final 메소드
메소드 앞에 final 이 붙으면 이 메소드는 더 이상 오버라이딩할 수 없음을 지정한다.
자식 클래스가 부모 클래스의 특정 메소드를 오버라이딩하지 못하게 하고 무조건 상속 받아 사용하도록 하고자 한다면 final로 지정하면 된다.

final 필드 
자바에서 final로 필드를 선언하면 필드는 상수가 된다.
상수 필드는 한 번 초기화되면 값을 변경할 수 없다. final 키워드를 public static과 함께 선언하면, 프로그램 전체에서 공유할 수 있는 상수가 된다.

상속(inheritance)
- 객체 지향 상속
자식이 부모 유전자를 물려 받는 것과 유사한 개념

상속의 장점
- 클래스 사이의 멤버 중복 선언 불필요 - 클래스의 간결화
- 클래스들의 계층적 분류로 클래스 관리 용어
- 클래스 재사용과 확장을 통한 소프트웨어의 생산성 향상

클래스 상속과 객체
- 상속 선언
extends 키워드로 선언 (부모 클래스를 물려받아 확장한다는 의미)
부모 클래스 -> 슈퍼 클래스(super class)
자식 클래스 -> 서브 클래스(sub class)
연습) EX5_1.java

서브 클래스 객체의 모양
- 슈퍼 클래스 객체와 서브 클래스의 객체는 별개
- 서브 클래스 객체는 슈퍼 클래스 멤버 포함

서브 클래스 객체 생성
Point 클래스의 객체 p와 Colorpoint 클래스의 객체 cp는 다음과 같이 생성한다.
    Point p = new Point();
    ColorPoint cp = new ColorPoint(); // 서브 클래스 객체 생성

자바 상속의 특징
- 클래스 다중 상속(multiple inheritance) 불허
 C++는 다중 상속 가능(C++는 다중 상속으로 멤버가 중복 생성되는 문제 있음)
 자바는 인터페이스(interface)의 다중 상속 허용
- 모든 자바 클래스는 묵시적으로 Object클래스 상속 받음
java.lang.Object는 클래스는 모든 클래스의 슈퍼 클래스

슈퍼 클래스의 멤버에 대한 서브 클래스의 접근
- 슈퍼 클래스의 private 멤버
 서브 클래스에서 접근할 수 없음
- 슈퍼 클래스의 디폴트 멤버
 서브 클래스가 동일한 패키지에 있을 때, 접근 가능
- 슈퍼 클래스의 public 멤버
 서브 클래스는 항상 접근 가능
- 슈퍼 클래스의 protected 멤버
 같은 패키지 내의 모든 클래스 접근 허용
 패키지 여부와 상관없이 서브 클래스는 접근 가능

protected 멤버
- proctected 멤버에 대한 접근
 같은 패키지의 모든 클래스에게 허용
 상속되는 서브 클래스(같은 패키지든 다른 패키지든 상관 없음)에게 허용

서브 클래스/슈퍼 클래스의 생성자 호출과 실행
- 서브 클래스의 객체가 생성될 때
 슈퍼 클래스 생성자와 서브 클래스 생성자 모두 실행
 호출 순서
 - 서브 클래스의 생성자 먼저 호출
 - 서브 클래스의 생성자는 실행 전 슈퍼 클래스 생성자 호출
 실행 순서
 - 슈퍼 클래스의 생성자가 먼저 실행된 후 서브 클래스의 생성자 실행

서브 클래스와 슈퍼 클래스의 생성자 선택
- 슈퍼 클래스와 서브 클래스
 각각 여러 개의 생성자 작성 가능
- 서브 클래스의 객체가 생성될 때
 슈퍼 클래스 생성자 1개와 서브 클래스 생성자 1개가 실행
- 서브 클래스의 생성자와 슈퍼 클래스의 생성자가 결정되는 방식
 1. 개발자의 명시적 선택
  - 서브 클래스 개발자가 슈퍼 클래스의 생성자 명시적 선택
  - super() 키워드를 이용하여 선택
 2. 컴파일러가 기본생성자 선택
  - 서브 클래스 개발자가 슈퍼 클래스의 생성자를 선택하지 않는 경우
  - 컴파일러가 자동으로 슈퍼 클래스의 기본 생성자 선택

super()
- 서브 클래스에서 명시적으로 슈퍼 클래스의 생성자 선택 호출
- 사용 방식
  1. super(parameter);
  2. 인자를 이용하여 슈퍼 클래스의 적당한 생성자 호출
  3. 반드시 서브 클래스 생성자 코드의 제일 첫 라인에 와야 함

업캐스팅
캐스팅(casting)이란 타입 변환을 말한다. 자바에서 클래스에 대한 캐스팅은 업캐스팅(upcasting)과 다운캐스팅(downcasting)으로 나뉜다.
서브 클래스는 슈퍼 클래스의 속성을 상속받는다. 
서브 클래스는 슈퍼 클래스로 취급될 수 있다.
- 서브 클래스의 레퍼런스를 슈퍼 클래스 레퍼런스에 대입
- 슈퍼 클래스 레퍼런스로 서브 클래스(객체를 가리키게 되는 현상)

다운캐스팅(downcasting)
- 슈퍼 클래스 레퍼런스를 서브 클래스 레퍼런스에 대입
- 업캐스팅된 것을 다시 원래대로 되돌리는 것
- 반드시 명시적 타입 변환 지정
    class Person{}
    class Student extends Person {}

    Person p = new Student("이재문"); // 업캐스팅

    Student s = (Student)p; // 다운캐스팅, 강제타입변환

업캐스팅 레퍼런스로 객체 구별
- 업캐스팅된 레퍼런스로는 객체의 실제 타입을 구분하기 어려움
  슈퍼 클래스는 여러 서브 클래스에 상속되기 때문

instanceof 연산자 사용
레퍼런스가 가리키는 객체의 타입 식별
(객체레퍼런스 instanceof 클래스타입) 연산의 결과 : true/false의 불린 값

메소드 오버라이딩(Method Overriding)
- 서브 클래스에서 서브 클래스의 메소드 중복 작성
- 슈퍼 클래스의 메소드 무력화, 항상 서브 클래스에 오버라이딩한 메소드가 실행되도록 보장됨
- "메소드 무시하기"로 번역되기도 함
오버라이딩 조건
- 슈퍼 클래스 메소드의 원형(메소드 이름, 인자 타입 및 개수, 리턴 타입) 동일하게 작성

오버라이딩으로 다형성 실현
- 하나의 인터페이스(같은 이름)에 서로 다른 구현
- 슈퍼 클래스의 메소드를 서브 클래스에서 각각 목적에 맞게 다르게 구현

super 키워드로 슈퍼 클래스의 멤버 접근
- 슈퍼 클래스의 멤버를 접근할 때 사용되는 레퍼런스
- 서브 클래스에서만 사용
- 슈퍼 클래스의 필드 접근
- 슈퍼 클래스의 메소드 호출 시
- super로 이루어지는 메소드 호출: 정적 바인딩

추상 클래스
추상 메소드(abstract method)
- abstract로 선언된 메소드, 메소드의 코드는 없고 원형만 선언
    abstract public String getName(); // 추상 메소드
    abstract public String fail() { return "Good Bye"; } // 추상 메소드 아님. 컴파일 오류

추상 클래스(abstract class)
- 추상 메소드를 가지며, abstract로 선언된 클래스
- 추상 메소드 없이, abstract로 선언한 클래스


## 4월 5일 강의
2차원 배열
- 2차원 배열의 선언과 생성
1차원 배열과 마찬가지로 2차원 배열에서도 레퍼런스 변수 선언 후 배열을 생성하며, 2차원 배열의 레퍼런스 변수를 선언
 int inArray[][]; 또는 int [][] intArray; // 2차원 배열의 레퍼런스 변수 선언
 intArray = new int[2][5]; // 2행 5열(2*5)의 2차원 배열 생성

 2차원 배열의 초기화
 - 2차원 배열을 선언할 때 각 원소를 초기화 할 수 있다. 자동으로 초기화된 배열이 생성된다.
 int inArray[][] = { {0,1,2}, {3,4,5}, {6,7,8} }; // 3*3 배열 생성
 char charArray[][] = { {'a','b','c'}, {'d','e','f'} }; // 2*3 배열 생성
 double doubleArray[][] = { {0.01,0.02}, {0.03,0.04} }; // 2*2 배열 생성

 자바의 예외 처리
 예외란 실행 중 오동작이나 결과에 악영향을 미치는 예상치 못한 상황 발생을 예외라고 한다.
 - 예외 발생 사례
  정수를 0으로 나누는 경우
  배열의 크기보다 큰 인덱스로 배열의 원소를 접근하는 경우
  정수를 읽는 코드가 실행되고 있을 때 사용자가 문자를 입력한 경우

자바의 예외 처리,try-catch-finally 문
예외 처리란 발생한 예외에 대해 개발자가 작성한 프로그램 내에서 대응하는 것을 말한다. 자바는 예외 처리시 try-catch-finally문을 사용
    try {
        예외가 발생할 가능성이 있는 실행문(try 블록)
    }
    catch (처리할 예외 타입 선언) {
        예외 처리문(catch 블록)
    }
    finally {
        예외 발생 여부와 상관없이 무조건 실행되는 문장(finally 블록)
    }

예외가 발생할 가능성이 있는 실행문들을 try{} 블록으로 묶고, 예외 처리 코드는 catch{} 블록에 작성한다.
catch() 문의 ()안에는 처리하고자 하는 예외의 타입을 선언한다. catch {} 블록은 예외마다 하나씩 작성되어야 한다.
finally {}는 선택적 구문으로서 생략해도 상관없으며 실제 많은 경우 생략한다.
finally 블록이 존재하는 경우, try 블록 실행 후 finally 블록이 순차적으로 실행되며, try 블록이 실행되는 도중 예외가 발생하였다면
catch 블록 실행 후 finally 블록을 실행한다. 그리고 finally 블록 아래의 코드를 계속 실행한다.
연습) EX3_13.java

객체 지향과 자바
- 자바의 객체 지향 특성
객체 지향 언어는 실세계의 객체를 프로그램 내에 표현하기 위해 클래스와 객체 개념을 도입하였다.

객체 지향 언어 특성
캡슐화: 객체를 캡슐로 싸서 그 내부를 보호하고 볼 수 없게 하는 것으로 가장 본질적인 특징이다.
실세계의 객체와 캡슐화 사례 = 캡슐약, TV, 자판기, 카메라, 사람
자바에서 클래스(class)는 객체의 모양을 선언한 틀이며, 클래스 모양 그대로 생성 된 실체(instance)가 객체이다.

상속(inheritance)
상위 개체의 속성이 하위 개체에 물려져서, 하위 개체가 상위 개체의 속성을 모두 가지는 관계이다.
자바의 상속은 자식 클래스가 부모 클래스의 속성을 물려받아 부모 클래스에 기능을 확장(extends)하는 개념이다.
자바에서 부모 클래스를 슈퍼 클래스(super class)라고 부르며 자식 클래스를 서브 클래스(sub class)라고 부른다,
상속은 슈퍼 클래스에 만들어진 필드와 메소드를 물려받음으로써 코드이 중복 작성을 방지하고, 코드를 재사용함으로써 코드 작성에 드는 시간과 비용을 줄인다.

다형성(polymorphism)
같은 이름의 메소드가 클래스 혹은 객체에 따라 다르게 구현 되는 것을 말한다.
슈퍼 클래스에 구현된 메소드를, 서브 클래스에서 자신의 특징에 맞게 동일한 이름으로 다시 구현하는 이른바 메소드 오버라이딩(overriding)으로 부른다.
다형성의 또 다른 사례는 클래스 내에서 같은 이름의 메소드를 여러 개 만드는 메소드 오버로딩(overloading)이 있다.

객체 지향 언어의 목적
- 소프트웨어의 생산성 향상
컴퓨터 산업이 발전함에 따라 소프트웨어의 생명 주기(life cycle)가 짧아졌으며, 이로 인해 빠른 시간 내에 새로운 소프트웨어를 만들어야 한다.
객체 지향 언어는 객체, 캡슐화, 상속, 다형성 등 소프트웨어의 재사용을 위한 여러 기법을 내장하고 있기 때문에, 이미 만든 소프트웨어를 상속받거나
재사용하기 쉬우며, 부분 수정을 통해 소프트웨어를 작성하는 부담을 대폭 줄일 수 있다.

- 실세계에 대한 쉬운 모델링
과거에는 통계 처리등 데이터의 처리 절차가 중요하였지만, 점점 컴퓨터가 산업 전반에 활용됨에 따라 실세계에서 발생하는 일을 프로그래밍 해야 하는 경우가
많아지게 되었고, 이에 따라 실세계의 일을 보다 쉽게 프로그래밍 할 수 있는 객체 지향 언어가 필요하게 되었다.

절차 지향 프로그래밍과 객체 지향 프로그래밍
C 언어처럼 실행하고자 하는 절차를 정하고, 이 절차대로 프로그래밍하는 방법을 절차 지향 프로그래밍이라고 부른다.
(절차 지향 프로그래밍)은 목적을 달성하기 위한 일의 흐름에 중점을 둔다.
(객체 지향 프로그래밍)은 실세상의 물체를 객체로 표현하고, 이들 사이의 관계, 상호 작용을 프로그램으로 나타낸다.

클래스와 객체
자바를 비롯한 객체 지향 언어에서 클래스는 객체를 만들어 내기 위한 설계 혹은 틀이며, 클래스에 선언된 모양 그대로 생성된 실체가 객체이다.
이러한 연유로 객체를 클래스의 인스턴스(instance)라고도 부르며, 가끔 객체와 인스턴스는 구별 없이 사용한다.

자바 클래스 구성
자바엣 class 키워드로 클래스를 선언한다.
클래스는 c 언어의 구조체와 같이 개발자가 정의하는 새로운 데이터 타입이다.
클래스의 구성 요소를 멤버라고 부르며, 멤버는 필드(멤버 변수)와 메소드(멤버 함수)의 두 가지이다.

- 클래스 구성
클래스는 class 키워드와 클래스 이름으로 선언하고 중괄호({}) 안에 클래스의 필드와 메소드를 모두 작성해햐 한다.
클래스 외부에 필드나 메소드를 결코 둘 수 없다.

- 클래스 멤버
클래스의 멤버는 필드(field)와 메소드(method)로서, 필드는 객체의 상태 값을 저장할 멤버 변수이며, 메소드는 실행 가능한 함수이고 객체의 행위를 구현한다.
getAtea()메소드는 원 내부의 반지름 정보를 이용하여 면적을 계산하여 알려준다.

- 접근 지정자
클래스의 선언부 앞에 붙여진 public은 접근 지정자로서, Circle 클래스를 다른 클래스에서 이용할 수 있음을 지정한다.
멤버를 public으로 선언하면 다른 클래스에서 마음대로 호출하거나 접근할 수 있도록 공개한다는 뜻이다.

객체 생성과 활용

1. 레퍼런스 변수 선언
객체를 생성하기 전 객체를 가리킬 레퍼런스 변수의 선언이 필요하다.
Circle pizza; // 레퍼런스 변수 pizza 선언
이 선언문으로 Circle 객체가 생성되지 않음 변수 pizza는 Circle 타입의 객체를 가리키는 레퍼런스 변수일 뿐 객체 자체는 아니다.
레퍼런스 변수를 '객체 이름'이라고도 부른다.

2. new 연산자로 객체 생성
자바에서는 반드시 new 연산자를 사용하여 다음과 같이 객체를 생성한다.
pizza = new Circle(); // Circle 객체 생성
new 연산자는 Circle 타입의 크기 만한 메모리를 할당받아 메모리에 대한 레퍼런스(주소)를 리턴한다.
레퍼런스(주소) 값은 변수 pizza에 대입된다.

3. 객체 멤버 접근
객체의 멤버에 접근할 때는 다음과 같이 점(). 연산자를 이용한다.
객체레퍼런스.멤버
pizza.radius = 10; // pizza 객체의 radius 값을 10으로 설정
pizza.name = "자바피자"; // pizza 객체의 name에 "자바피자" 대입
double area = pizza.getArea(); // pizza 객체의 getAtea() 메소드 호출
연습) EX4_2.java

생성자
생성자의 개념과 목적
클래스는 객체를 생성하기 위한 설계도 또는 틀이며 객체는 설계도 또는 틀로 찍어낸 실체라고 하였다.
생성자는 객체가 생성될 때 초기화를 위해 실행되는 메소드이다.
생성자 개념은 자바, C++, C# 등 거의 모든 객체 지향 언어에 존재하며 사용하는 방법 또한 거의 비슷하다.

생성자 작성 및 활용
생성자는 객체가 생성되는 순간에 자동으로 호출되는 메소드로서, 객체에 필요한 기화를 수행하는 코드이다.

- 생성자의 이름은 클래스 이름과 동일하다.
생성자는 반드시 클래스의 이름과 동일하게 작성되어야 한다. 이로 인해 다른 메소드와 쉽게 구분된다.

- 생성자를 여러 개 작성할 수 있다.
매개 변수의 개수와 타입만 다르다면, 클래스 내에 생성자를 여러 개 둘 수 있다.
    public class Circle {
        public Circle() {} // 매개 변수 없는 생성자
        public Circle(int r. String n) {} // 2개의 매개 변수를 가진 생성자
    }

- 생성자는 객체를 생성할 때 한 번만 호출된다.
생성자는 객체를 생성할 때만 자동으로 호출되는 메소드이다. 컴파일러는 new문장이 실행될 때
적절한 생성자가 호출되도록 컴파일한다.
    Circle pizza = new Circle(10, "자바피자"); // 생성자 Circle(int r, String n) 호출
    Circle dount = new Circle(); // 생성자 Circle() 호출

- 생성자에 리턴 타입을 지정할 수 없다.
생성자는 어떤 리턴 타입도 선언해서는 안된다.
    public Circle() {}
리턴할 값이 없다고 해서, void를 리턴 타입으로 지정해서는 안됨
    오류 public void Circle() {} // 오류. void를 리턴 타입으로 사용할 수 없음

- 생성자의 목적은 객체가 생성될 때, 필요한 초기 작업을 위함이다.
다음 new의 객체 생성 문은 Circle(int r, String n) 생성자를 호출하여, pizza 객체의 radius 필드를 10으로, name 필드를 "자바피자"로 초기화
    Circle pizza = new Circle(10, "자바피자"); // 생성자 Circle(int r, String n) 호출

생성자는 객체가 생성될 대, 객체의 필드에 초깃값을 설정하거나, 필요한 메모리를 확보하거나, 파일을 열거나, 네트워크를 연결하는 등 객체가 활동하기 전에
필요한 초기화를 하기 위한 목적이다.
연습) Book.java

기본 생성자(default constructor)
매개 변수가 없고 또한 실행 코드가 없어 아무일도 하지 않고 단순 리턴하는 생성자이다. 디폴트 생성자라고도 부른다.
    class Circle {
        public Circle() // 기본 생성자, 매개 변수 없고, 아무 일 없이 단순 리턴
    }

- 기본 생성자가 자동으로 생성되는 경우
생성자가 없는 클래스는 있을 수 없다. 클래스에 생성자가 하나도 선언되어 있지 않은 경우,
컴파일러는 기본 생성자를 자동으로 생성한다.
    Circle pizza = new Circle(); // 생성자 Circle() 호출

- 기본 생성자가 자동으로 생성되지 않은 경우
    Circle pizza = new Circle(10); // circle(int r) 호출
    오류 Circle dount = new Circle(); // 컴파일 오류. 생성자 Circle() 없음

this 레퍼런스
this 는 객체 자신에 대한 레퍼런스로서 메소드 안에서 사용된다.
this는 컴파일러에 의해 자동으로 관리되므로, 개발자는 사용하기만 하면 된다.

this()로 다른 생성자 호출
this()는 클래스 내에서 생성자가 다른 생성자를 호출 할 때 사용하는 자바 코드이다.

this() 사용 시에 몇 가지 주의할 사항
 1. this()는 생성자에서만 사용된다.
 2. this()는 반드시 같은 클래스의 다른 생성자를 호출할 때 사용된다.
 3. this()는 반드시 생성자의 첫 번째 문장으로 사용되어야 한다.

객체 배열
자바에서 객체를 원소로 하는 배열을 만들 수 있다. C/C++의 객체 배열과 달리 자바의 객체 배열은
객체이 대한 레퍼런스를 원소로 갖는 배열이며 만드는 방법 또한 다르다.

배열 선언 및 생성
 1. 배열에 대한 레퍼런스 선언
 Circle 클래스의 배열에 대한 레퍼런스 변수 c를 선언한다.
 Circle [] c;

2. 레퍼런스 배열 생성
    c= new Circle[5]; // Circle 객체에 대한 레퍼런스 5개 생성

3. 객체 생성
    for(int i=0; i<c.length; i++) // c.length는 배열 c의 크기로서 5
        c[i] = new Circle(i); // i 번째 Circle 객체 생성

배열의 원소 객체 접근
배열 c의 i번째 객체를 접근하기 위해서는 c[i] 레퍼런스를 사용한다.
    for(int i=0; i<c.length; i++)
        System.out.print((int)(c[i].getArea)) + " ");



## 3월 29일 강의
타입 변환이란 변수나 상수 혹은 리터럴을 다른 타입을 변환하는 것을 말한다.
- 자동 타입 변환: 치환문(=)이나 수식 내에서 타입이 일치하지 않을 때, 컴파일러는 작은 타입을 큰 타입으로 자동 변환
- 강제 타입 변환(캐스팅): 큰 타입을 작은 타입으로 변환해야 할 때 자동 변환 대신 컴파일 오류 발생 손실이 발생한다는 사실을 알고 변환한다면 강제로 ()안에 타입을 지정

자바의 키 입력
- System.in
표준 입력 스트림 객체로, 키 갑을 바이트 정보로 바꾸어 제공하는 저수준(low-level) 스트림 객체

Scanner를 이용한 키 입력
- Scanner 객체는 다음과 같이 생성 한다. 
"Scanner scanner = new Scanner(System.in);"
- Scanner를 사용하기 위해서는 프로그램의 맨 앞줄에 "import" 문이 필요하다.
"import java.util.Scanner;"
import 문은 Scanner 클래스의 경로명이 java.util.Scanner임을 알려준다.
import 문이 없으면 자바 컴파일러가 Scanner 클래스 코드가 어디에 있는지 찾을수 없다.

예제 2-5(EX2_5.java) 연습

식과 연산자 
- 주어진 식(expression)을 계산하여 결과를 얻어내는 과정을 연산이라고 한다.
- a + 5 식(expression), a(피연산자 operand) ==(연산자 operator) n(피연산자operand)

산술 연산
- 수식 계산에 사용하는 산술 연산자는 더하기, 빼기, 곱하기, 나누기, 나머지(%)의 5개다 /는 몫을 구하며, %는 나머지를 구한다.

예제 2-6(EX2_6.java) 연습

증감 연산
- ++,-- 피연산자의 앞 또는 뒤에 붙어 값을 1 증가시키거나 1 감소시킨다.
a++ a를 1 증가하고 증가 전의 값 반환
++a a를 1 증가하고 증가된 값 반환
a-- a를 1 감소하고 감소 전의 값 반환
--a a를 1 감ㅅ하고 감소된 값 반환

대입 연산
- 연산자의 오른쪽 식의 결과를 왼쪽에 잇는 변수에 대입한다.
"a = b" b의 값을 a에 대입, "a += b" a = a + b와 동일, "a -= b" a = a - b와 동일
"a *= b" a = a * b와 동일, "a /= b" a = a / b와 동일, "a %= b" a = a % b와 동일
" a &= b" a = a & b와 동일, "a ^= b" a = a ^ b와 동일, "a l= b" a = a l b와 동일
"a <<= b" a = a << b와 동일, "a >>= b" a = a >>b 와 동일, "a >>>= " a = a >>> b와 동일

비교 연산, 논리 연산
- 비교 연산자는 두 개의 피연사자를 비교하여 true 또는 false의 논리 결과를 내는 연산자
- 논리 연산자는 논리 값을 대상으로 AND, OR, XOR, NOT의 논리 연산을 하여 논리 값을 내는 연산자

조건문
- 단순 if 문 조건식은 비교 연산이나 논리 연산의 혼합된 식으로 구성되며 결과는 불린 값이다. 
- 조건식이 참(true)이면 if 내부의 '실행 문장'이 실행되며, 거짓(false)이면 if 문을 벗어난다.
- if-else 문은 if의 '조건식'이 참인 경우와 거짓인 경우에 실행할 문장을 각각 지시한다.
- 다중 if-else 문은 '조건식'이 참인 경우, 해당하는 '실행 문장'을 실행한 후 다중 if-else 전체를 벗어난다.
- 중첩 if-else 문 if 문이나 if-else 문, 혹은 else문의 '실행 문장'에 if 문이나 if-else 문을 내포할 수 있다.
- switch문 먼저 '식'을 계산하고 그 결과 값과 일치하는 case문으로 분기한다.
값에 따라 여러 방향으로 분기하는 경우, if문보다 switch문을 사용하면 가독성이 높은 좋은 코드를 작성할 수 있다.

반복문
- for 문 '작업문'은 for 문이 반복되는 동안 매번 실행되며, '작업문'이 하나의 문장인 경우 중괄호({})가 필요 없다.
'초기문'에서는 대개 for 문의 '조건식'에서 사용하는 변수를 초기화 한다. '조건식'에는 논리 변수나 논리 연산을 사용하며
'조건식'의 결과가 true인 경우에 반복이 계속되고 false가 되면 for문을 벗어난다.
- while 문 
'조건식'은 for문과 동일하다. true인 경우 반복이 계속되며, false인 경우 while 문을 벗어난다.
for 문과 달리 '조건식'이 없으면 컴파일 오류가 발생한다,
- do-while 문
'조건식'은 while 문과 동일하며, '조건식'이 없으면 컴파일 오류가 발생한다. do-while 문은 다른 반복문과 달리 '작업문' 실행 후
반복 조건을 따지므로, '작업문'이 최초 한 번은 반드시 실행된다.
- 중첩 반복
반복문 안에 다른 반복문을 만들 수 있다. 이것을 중첩 반복이라한다.
for 문 안에 for 문이나 while 문을 둘 수도 있고, while문 안에 for, while, do-while 문을 둘수 있다.
- contine 문
continue 문은 반복문을 빠져나가지 않으면서 즉시 다음 반복으로 넘어가고자 할 때 사용된다.
for 문에서 continue 문을 만나면 '반복 후 작업'으로 분기하고, while 문이나 do-while 문에서는 '조건식'을 검사하는 과정을 분기한다.
- break 문
break 문은 하나의 반복문을 즉시 벗어날 때 사용하며 한다
break 문이 실행되면 현재의 반복문을 벗어나, 다음 코드로 실행이 계속된다
break 문은 하나의 반복문만 벗어나기 때문에, 중첩 반복의 경우 안쪽 반복문에서 break 문이 실행되면
안족 반복문만 벗어나며 바깥 쪽 반복문 내에서 실행이 유지된다.

배열
- 배열(array)은 인덱스(index)와 인덱스에 대응하는 일련의 데이터들로 이루어진 연속적인 자료 구조로서,
배열에는 같은 종류의 데이터들이 순차적으로 저장된다.
- 배열 선언 및 생성
자바에서 배열을 생성하는 방법은 C/C++와 달리 레퍼런스 변수 선언과 배열 생성의 두 단계가 필요하다


## 3월 22일 강의
자바 프로젝트, 클래스 생성 뒤 소스 편집, 컴파일 및 실행 
자바 응용프로그램의 종류
- 데스크톱 응용프로그램
- 자바 서블릿 응용프로그램
- 모바일 응용프로그램

자바의 특징
플랫폼 독립성, 객체 지향, 클래스로 캡슐화, 소스와 클래스파일, 실행 코드 배포, 패키지, 멀티스레드, 가비지 컬렉션, 실시간 응용 시스템에 부적합
자바 프로그램은 안전하다, 프로그램 작성이 쉽다, 실행 속도를 개선하기 위해 JIT 컴파일러가 사용됨 여기까지가 자바의 특징이다.

자바 프로그램의 구조
- 클래스 만들기
- 주석문
- main() 메소드
- 메소드
- 메소드 호출
- 변수 선언
- 문장
- 화면 출력

식별자: 클래스, 변수, 상수, 메소드에 붙이는 이름(identifier)
식별자 이름 규칙에서 식별자를 만들 대 규칙을 준수 하여야 한다.
1. 식별자로 한글을 사용할 수 있다.
2. 길이 제한이 없다.
3. 대소문자를 구별한다.


## 3월 15일 강의
깃 허브 주소를 복사하여 vscode에 붙여넣고 깃허브를 활용하는 배웠다.
source control 에서 내용을 넣고 comit을 누르고 업로드를 하면 나의 깃허브 주소에 vs code에서 작성한 내용이 올라간다.
java 개발 환경 구축
openJDK 설치, Eclips 설치, Eclips에 openJDK 연결
자바 프로젝트 생성