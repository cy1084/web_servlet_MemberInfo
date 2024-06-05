-- 전체 사용자 조회
SELECT SEQ ,ID ,PASSWORD ,NAME ,ADDRESS ,PHONE ,EMAIL ,ENABLE ,AUTH  
 FROM MEMBERINFO m ;

-- 사용 가능한 사용자 조회
SELECT SEQ ,ID ,PASSWORD ,NAME ,ADDRESS ,PHONE ,EMAIL ,ENABLE ,AUTH  
 FROM MEMBERINFO m 
 WHERE ENABLE ='Y';

-- 권한 수정
UPDATE MEMBERINFO SET AUTH ='ADMIN'
 WHERE SEQ='1';

-- 사용자 입력
INSERT INTO MEMBERINFO m (SEQ ,ID ,PASSWORD ,NAME ,ADDRESS ,PHONE ,EMAIL ,ENABLE ,AUTH)
 VALUES(MEMEBERINFO_SEQ.NEXTVAL, 'TEST','TEST','TEST','TEST','000','HAPPY@HAPPY.COM','Y','USER');

-- 로그인
SELECT SEQ ,ID, NAME ,AUTH
 FROM MEMBERINFO m 
 WHERE ID='HAPPY'
 AND PASSWORD ='HAPPY'
 AND ENABLE ='Y';

-- 사용자 상세정보
SELECT SEQ ,ID ,PASSWORD ,NAME ,ADDRESS ,PHONE ,EMAIL ,ENABLE ,AUTH  
 FROM MEMBERINFO m 
 WHERE SEQ='1';

-- 사용자 정보 수정
UPDATE MEMBERINFO SET ADDRESS ='금천구',PHONE='',EMAIL ='HAPPY@NAVER.COM'
 WHERE SEQ='1';

-- 사용자 삭제
UPDATE MEMBERINFO SET ENABLE ='N'
 WHERE SEQ='1';

-- 아이디 중복 체크
SELECT ID
 FROM MEMBERINFO m 
 WHERE ID='HAPPY';