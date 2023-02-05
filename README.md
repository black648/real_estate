# 개발환경
- Language  : Java11
- FrameWork : SpringBoot 2.7.6
  QueryDSL 5.0
- DB : MariaDB, H2

# 환경설정
1. DB
   1. 설정
      - 초기 관리자 계정 설정
       set password for 'root'@'localhost' = password('변경할 비밀번호');
      - DB 생성
        CREATE DATABASE travel CHARACTER SET='utf8' COLLATE='utf8_bin';
      - 사용자 생성
        CREATE USER travel IDENTIFIED BY 'travel';
      - 로컬 DB접근 허용
        GRANT ALL PRIVILEGES on ecm.* to 'travel’@‘localhost’ identified by 'travel';
      
   2. init Row 생성
      1. Code
         * insert into code_group (cd, description, max_level, name, order_no, use_able)
           values ('R001', '방 구조에 대한 코드 정보', 1, '방 구조', 1, 'Y');
         * insert into code (cd, description, group_cd, level, name, order_no, parent_cd, use_able)
           values ('R00101', '방 구조 > 원룸', 'R001', 1, '원룸', 1, 'R001', 'Y');
         * insert into code (cd, description, group_cd, level, name, order_no, parent_cd, use_able)
           values ('R00102', '방 구조 > 투룸', 'R001', 1, '투룸', 2, 'R001', 'Y');
         * insert into code (cd, description, group_cd, level, name, order_no, parent_cd, use_able)
           values ('R00103', '방 구조 > 쓰리룸', 'R001', 1, '쓰리룸', 3, 'R001', 'Y');
         * insert into code_group (cd, description, max_level, name, order_no, use_able)
           values ('D001', '방 거래방식에 대한 코드 정보', 1, '방 거래방식', 1, 'Y');
         * insert into code (cd, description, group_cd, level, name, order_no, parent_cd, use_able)
           values ('D00101', '방 거래방식 > 월세', 'D001', 1, '원룸', 1, 'D001', 'Y');
         * insert into code (cd, description, group_cd, level, name, order_no, parent_cd, use_able)
           values ('D00102', '방 거래방식 > 전세', 'D001', 1, '투룸', 2, 'D001', 'Y');
         * insert into code (cd, description, group_cd, level, name, order_no, parent_cd, use_able)
           values ('D00103', '방 거래방식 > 매매', 'D001', 1, '쓰리룸', 3, 'D001', 'Y');

