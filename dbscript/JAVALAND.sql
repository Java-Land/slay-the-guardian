DROP TABLE HAS_ITEM;
DROP TABLE HAS_POTION;
DROP TABLE ITEM;
DROP TABLE PLAYER;
DROP TABLE PLAYER_INFO;
DROP TABLE POTION;
DROP TABLE USER_LOG;

CREATE TABLE PLAYER (
	USER_ID	VARCHAR2(50) CONSTRAINT PK_USER_ID PRIMARY KEY,
	USER_PWD	VARCHAR2(50)		NOT NULL,
	USER_DEATHCOUNT	NUMBER	DEFAULT 0	NULL,
	USER_BL_YN	CHAR(1)	DEFAULT 'N'	NOT NULL,
    CONSTRAINT CK_USER_BL_YN CHECK(USER_BL_YN IN ('Y', 'N'))
);

COMMENT ON COLUMN PLAYER.USER_ID IS '사용자아이디';
COMMENT ON COLUMN PLAYER.USER_PWD IS '사용자비밀번호';
COMMENT ON COLUMN PLAYER.USER_DEATHCOUNT IS '사용자죽은횟수';
COMMENT ON COLUMN PLAYER.USER_BL_YN IS '사용자 블랙리스트 여부';

CREATE TABLE PLAYER_INFO (
	PLAYER_CODE	NUMBER CONSTRAINT PLAYER_CODE PRIMARY KEY,
	PLAYER_ID	VARCHAR2(50)		NOT NULL,
	PLAYER_HP	NUMBER DEFAULT 100	NOT NULL,
	PLAYER_MAX_HP	NUMBER DEFAULT 100	NOT NULL,
	PLAYER_SP	NUMBER	DEFAULT 10	NOT NULL,
	PLAYER_DP	NUMBER	DEFAULT 5	NOT NULL,
	PLAYER_GOLD	NUMBER	DEFAULT 0	NOT NULL,
	PLAYER_EXP	NUMBER	DEFAULT 0	NOT NULL,
	PLAYER_LEVEL	NUMBER DEFAULT 1	NOT NULL,
	PLAY_TIME	DATE		NULL,
	PLAYER_LIVE_YN	CHAR(1)	DEFAULT 'Y'	NOT NULL,
	STAGE1_CLEAR_YN	CHAR(1)	DEFAULT 'N'	NOT NULL,
	STAGE2_CLEAR_YN	CHAR(1)	DEFAULT 'N'	NOT NULL,
    CONSTRAINT CK_PLAYER_LIVE_YN CHECK(PLAYER_LIVE_YN IN ('Y', 'N')),
    CONSTRAINT CK_STAGE1_CLEAR_YN CHECK(STAGE1_CLEAR_YN IN ('Y', 'N')),
    CONSTRAINT CK_STAGE2_CLEAR_YN CHECK(STAGE2_CLEAR_YN IN ('Y', 'N')),
    CONSTRAINT FK_PLAYER_ID FOREIGN KEY (PLAYER_ID) 
    REFERENCES PLAYER (USER_ID) ON DELETE CASCADE
);

COMMENT ON COLUMN PLAYER_INFO.PLAYER_CODE IS '캐릭터 식별 코드';
COMMENT ON COLUMN PLAYER_INFO.PLAYER_ID IS '사용자아이디';
COMMENT ON COLUMN PLAYER_INFO.PLAYER_HP IS '플레이어 현재 체력';
COMMENT ON COLUMN PLAYER_INFO.PLAYER_MAX_HP IS '플레이어의 최대 체력';
COMMENT ON COLUMN PLAYER_INFO.PLAYER_SP IS '플레이어 공격력';
COMMENT ON COLUMN PLAYER_INFO.PLAYER_DP IS '플레이어 방어력';
COMMENT ON COLUMN PLAYER_INFO.PLAYER_GOLD IS '플레이어 보유 골드';
COMMENT ON COLUMN PLAYER_INFO.PLAYER_EXP IS '플레이어 경험치 DEFAULT 0';
COMMENT ON COLUMN PLAYER_INFO.PLAYER_LEVEL IS '플레이어 레벨';
COMMENT ON COLUMN PLAYER_INFO.PLAYER_LIVE_YN IS '캐릭터가 죽었는지 살았는지 판별하는 컬럼';

CREATE TABLE USER_LOG (
	LOGIN_NO NUMBER CONSTRAINT LOGIN_NO PRIMARY KEY,
	USER_ID	VARCHAR2(50)		NOT NULL,
	CONNECT_TIME	DATE		NULL,
	LOGOUT_TIME	DATE		NULL,
	LOGIN_TIME	DATE		NULL,
    CONSTRAINT FK_USER_ID FOREIGN KEY (USER_ID) 
    REFERENCES PLAYER (USER_ID) ON DELETE CASCADE
);

COMMENT ON COLUMN USER_LOG.USER_ID IS '사용자아이디';
COMMENT ON COLUMN USER_LOG.CONNECT_TIME IS '총 플레이타임 (로그아웃 시간 - 로그인시간)';
COMMENT ON COLUMN USER_LOG.LOGOUT_TIME IS '로그아웃 버튼 입력 시간';
COMMENT ON COLUMN USER_LOG.LOGIN_TIME IS '로그인 버튼 입력 시간';

INSERT
  INTO PLAYER A
    (
      A.USER_ID
    , A.USER_PWD
    )
  VALUES
    (
      'user01'
    , 'pass01'
    );

INSERT
  INTO PLAYER_INFO A
    (
      A.PLAYER_CODE
    , A.PLAYER_ID
    , A.PLAY_TIME
    )
  VALUES
    (
      SEQ_LOGIN_NO.NEXTVAL
    , 'user01'
    , SYSDATE
    );

INSERT 
  INTO USER_LOG A
    (
      A.LOGIN_NO
    , A.USER_ID
    )
  VALUES
    (
      SEQ_LOGIN_NO.NEXTVAL
    , 'user01'
    );

DROP SEQUENCE SEQ_PLAYER_CODE;
CREATE SEQUENCE SEQ_PLAYER_CODE
START WITH 1;

DROP SEQUENCE SEQ_LOGIN_NO;
CREATE SEQUENCE SEQ_LOGIN_NO
START WITH 1;

COMMIT;

