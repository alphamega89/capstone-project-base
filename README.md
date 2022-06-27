# git fork
## 메인의 깃팟 실행 -- 시연시사용
#각자 포크한 깃팟에서 수정분 깃헙에 커밋하고, 풀리퀘스트 하면, 메인에서 커밋해준다.
메인 깃팟 https://gitpod.io/#https://github.com/alphamega89/capstone-project-base
##  다시 수정분 해보자

## 소스  운영버전 pull 명령어
git fetch upstream
git checkout main
git merge upstream/main
git push origin main


## 깃팟 다시 해보자
# 캡스톤 프로젝트 환경


```
브레인스토밍 https://labs.msaez.io/#/courses/cna-full/be513ff0-e2d5-11ec-b71d-f90e603c5333/capstone-team/alphamega89@naver.com

```



기능적 요구사항

1. 아이디/패스워드 기반으로 로그인한다.
2. 정상 고객인지 확인한다. 
3. 청년희망적ㄱ
4. 사전희망적금 신청하면 소득검증한다.
5. 소득검증결과에 따라 계좌개설-- 알림--



 2-1 고객이 해지할 수 있다.
 2-2 고객해지가 되면 뱅킹아이디도 해지된다.
3. 아이디와 패스워드  일치하는지 확인한다. 
4. 아이디/패스워드가 일치하면 로그인 성공한다.
 4-1 해당 고객의 계좌와 잔액을 불러온다. 
 4-2 로그인이 완료된다. 
 4-3 자신의 계좌와 잔액 정보를 확인할 수 있다. 




비기능적 요구사항
1. 트랜잭션
- 고객 상태가 정상이지 않으면 로그인 할 수 없다.
- 뱅킹회원 상태가 정상이지 않으면 로그인 할 수 없다.
- 아이디/비밀번호가 일치하지 않으면 로그인 할 수 없다. 


2. 장애격리

- 고객 및 상품팀 서비스 장애 중이더라도, 고객은 로그인 가능해야 한다. (365/24시간) (Async)
- 상품서비스가 불안정 하더라도 손님은 자신의 계좌와 최근 잔액 상태를 조회할 수있어한다. (Async)
- 로그인 시도가 과중되면 잠시 로그인 시도를 받지 않고 잠시 후에 하도록 유도한다. (Circuit breaker, fallback)

3. 성능
로그인 후 가장 최근의 계좌 상태 및 잔액을 조회할 수 있어야한다. (CQRS)
고객의 상태 및 계좌의 잔액 변경이 되면 조회 할 수있어야 한다. (Event driven)

체크포인트
분석 설계

이벤트스토밍:

스티커 색상별 객체의 의미를 제대로 이해하여 헥사고날 아키텍처와의 연계 설계에 적절히 반영하고 있는가?
각 도메인 이벤트가 의미있는 수준으로 정의되었는가?
어그리게잇: Command와 Event 들을 ACID 트랜잭션 단위의 Aggregate 로 제대로 묶었는가?
기능적 요구사항과 비기능적 요구사항을 누락 없이 반영하였는가?
서브 도메인, 바운디드 컨텍스트 분리

팀별 KPI 와 관심사, 상이한 배포주기 등에 따른  Sub-domain 이나 Bounded Context 를 적절히 분리하였고 그 분리 기준의 합리성이 충분히 설명되는가?

적어도 3개 이상 서비스 분리
폴리글랏 설계: 각 마이크로 서비스들의 구현 목표와 기능 특성에 따른 각자의 기술 Stack 과 저장소 구조를 다양하게 채택하여 설계하였는가?
서비스 시나리오 중 ACID 트랜잭션이 크리티컬한 Use 케이스에 대하여 무리하게 서비스가 과다하게 조밀히 분리되지 않았는가?
컨텍스트 매핑 / 이벤트 드리븐 아키텍처

업무 중요성과  도메인간 서열을 구분할 수 있는가? (Core, Supporting, General Domain)
Request-Response 방식과 이벤트 드리븐 방식을 구분하여 설계할 수 있는가?
장애격리: 서포팅 서비스를 제거 하여도 기존 서비스에 영향이 없도록 설계하였는가?
신규 서비스를 추가 하였을때 기존 서비스의 데이터베이스에 영향이 없도록 설계(열려있는 아키택처)할 수 있는가?
이벤트와 폴리시를 연결하기 위한 Correlation-key 연결을 제대로 설계하였는가?
헥사고날 아키텍처

설계 결과에 따른 헥사고날 아키텍처 다이어그램을 제대로 그렸는가?
구현

[DDD] 분석단계에서의 스티커별 색상과 헥사고날 아키텍처에 따라 구현체가 매핑되게 개발되었는가?

Entity Pattern 과 Repository Pattern 을 적용하여 JPA 를 통하여 데이터 접근 어댑터를 개발하였는가
[헥사고날 아키텍처] REST Inbound adaptor 이외에 gRPC 등의 Inbound Adaptor 를 추가함에 있어서 도메인 모델의 손상을 주지 않고 새로운 프로토콜에 기존 구현체를 적응시킬 수 있는가?
분석단계에서의 유비쿼터스 랭귀지 (업무현장에서 쓰는 용어) 를 사용하여 소스코드가 서술되었는가?
Request-Response 방식의 서비스 중심 아키텍처 구현

마이크로 서비스간 Request-Response 호출에 있어 대상 서비스를 어떠한 방식으로 찾아서 호출 하였는가? (Service Discovery, REST, FeignClient)
서킷브레이커를 통하여  장애를 격리시킬 수 있는가?
이벤트 드리븐 아키텍처의 구현

카프카를 이용하여 PubSub 으로 하나 이상의 서비스가 연동되었는가?
Correlation-key: 각 이벤트 건 (메시지)가 어떠한 폴리시를 처리할때 어떤 건에 연결된 처리건인지를 구별하기 위한 Correlation-key 연결을 제대로 구현 하였는가?
Message Consumer 마이크로서비스가 장애상황에서 수신받지 못했던 기존 이벤트들을 다시 수신받아 처리하는가?
Scaling-out: Message Consumer 마이크로서비스의 Replica 를 추가했을때 중복없이 이벤트를 수신할 수 있는가
CQRS: Materialized View 를 구현하여, 타 마이크로서비스의 데이터 원본에 접근없이(Composite 서비스나 조인SQL 등 없이) 도 내 서비스의 화면 구성과 잦은 조회가 가능한가?
폴리글랏 플로그래밍

각 마이크로 서비스들이 하나이상의 각자의 기술 Stack 으로 구성되었는가?
각 마이크로 서비스들이 각자의 저장소 구조를 자율적으로 채택하고 각자의 저장소 유형 (RDB, NoSQL, File System 등)을 선택하여 구현하였는가?
API 게이트웨이

API GW를 통하여 마이크로 서비스들의 집입점을 통일할 수 있는가?
게이트웨이와 인증서버(OAuth), JWT 토큰 인증을 통하여 마이크로서비스들을 보호할 수 있는가?
운영

SLA 준수

셀프힐링: Liveness Probe 를 통하여 어떠한 서비스의 health 상태가 지속적으로 저하됨에 따라 어떠한 임계치에서 pod 가 재생되는 것을 증명할 수 있는가?
서킷브레이커, 레이트리밋 등을 통한 장애격리와 성능효율을 높힐 수 있는가?
오토스케일러 (HPA) 를 설정하여 확장적 운영이 가능한가?
모니터링, 앨럿팅:
무정지 운영 CI/CD (10)

Readiness Probe 의 설정과 Rolling update을 통하여 신규 버전이 완전히 서비스를 받을 수 있는 상태일때 신규버전의 서비스로 전환됨을 siege 등으로 증명
Contract Test : 자동화된 경계 테스트를 통하여 구현 오류나 API 계약위반를 미리 차단 가능한가?










1. Fork (내 저장소로 환경 복제)
이 Repo 를 먼저 Fork 합니다. github 의 우상단 Fork를 클릭

1. 본인의 레포지토리를 확인
e.g. github.com/내계정/capstone-project-base

1. Gitpod 로 접속
본인의 레포지토리 주소 앞에 "gitpod.io/#" 을 넣고 접속 
```
https://gitpod.io/#https://github.com/alphamega89/capstone-project-base
```
1. VS Code 접속 및 Language Server 확인
- VS Code 접속 후, store-domain > main > java 내의 Java 파일을 하나 Open
- Java Language Server 가 기동되는 것을 꼭 확인
- Java Language Support 플러그인을 설치한다는 메시지에 꼭 "Install" 해줄것
- 혹시 Reload Window, Restart Now 하겠다는 메시지가 들어오면 그것도 수락


## 오리엔테이션
https://www.youtube.com/embed/u-C1mrSUAjg


### 평가 항목
https://workflowy.com/s/c10811dfdb67/UhOZB2crKOhNPUYp


## 로컬 유틸리티 설치

- httpie (curl / POSTMAN 대용)
```
pip install httpie
```

- Kafka (by docker)
```
cd kafka
docker-compose up -d     # docker-compose 가 모든 kafka 관련 리소스를 받고 실행할 때까지 기다림
```
 Kafka 정상 실행 확인
```
$ docker-compose logs kafka | grep -i started    

kafka-kafka-1  | [2022-04-21 22:07:03,262] INFO [KafkaServer id=1] started (kafka.server.KafkaServer)
```
Kafka consumer 접속
```
docker-compose exec -it kafka /bin/bash   # kafka docker container 내부 shell 로 진입

[appuser@e23fbf89f899 bin]$ cd/bin
[appuser@e23fbf89f899 bin]$ ./kafka-console-consumer --bootstrap-server localhost:9092 --topic petstore
```
> Docker compose 를 이용한 kafka 는 29090 으로 접속해야 합니다. 따라서 application.yml 의 broker 설정의 포트넘버 수정 (9092 -> 29092)이 필요합니다.

- Kafka local installation 

Download
```
wget https://dlcdn.apache.org/kafka/3.1.0/kafka_2.13-3.1.0.tgz
tar -xf kafka_2.13-3.1.0.tgz
```

Run Kafka
```
cd kafka_2.13-3.1.0/
bin/zookeeper-server-start.sh config/zookeeper.properties &
bin/kafka-server-start.sh config/server.properties &
```

Kafka Event 컨슈밍하기 (별도 터미널)
```
cd kafka_2.13-3.1.0/
bin/kafka-console-consumer.sh --bootstrap-server 127.0.0.1:9092 --topic petstore
```

## 클라우드 관련 유틸리티

- kubectl 설치
https://kubernetes.io/docs/tasks/tools/install-kubectl-linux/

- awscli 설치
https://docs.aws.amazon.com/ko_kr/cli/latest/userguide/getting-started-install.html

- eksctl 설치
https://docs.aws.amazon.com/ko_kr/eks/latest/userguide/eksctl.html

## 쿠버네티스 

### Helm(패키지 인스톨러) 설치
- Helm 3.x 설치
```bash
curl https://raw.githubusercontent.com/helm/helm/master/scripts/get-helm-3 > get_helm.sh
chmod 700 get_helm.sh
./get_helm.sh
```

#### Kafka 설치
```bash
helm repo update
helm repo add bitnami https://charts.bitnami.com/bitnami
helm install my-kafka bitnami/kafka
```

#### Nginx ingress 설치
https://www.ibm.com/docs/ko/control-desk/7.6.1.x?topic=kubernetes-installing-nginx-ingress-controller-in-cluster
```bash
helm upgrade --install ingress-nginx ingress-nginx \
  --repo https://kubernetes.github.io/ingress-nginx \
  --namespace ingress-nginx --create-namespace
```

## 자주 쓰는 명령
- 포트 확인 및 점유 프로세스 삭제
```bash
cmd(포트확인) : netstat -lntp | grep :808 
tcp        0      0 0.0.0.0:8080            0.0.0.0:*               LISTEN      3752/java           
tcp        0      0 0.0.0.0:8081            0.0.0.0:*               LISTEN      3109/java           
cmd : kill -9 3109  <-- 해당 pid
모든 점유 프로세스 삭제 : kill -9 `netstat -lntp|grep 808|awk '{ print $7 }'|grep -o '[0-9]*'`
```

- httpie pod 생성
https://github.com/TheOpenCloudEngine/uEngine-cloud/wiki/Httpie-%EC%84%A4%EC%B9%98


- siege pod 생성
https://github.com/JoeDog/siege.git
