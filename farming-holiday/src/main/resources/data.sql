INSERT INTO user(user_type, email, password, name, birth, phone_number, address, detail_address, image_path)
VALUES ('HOST', 'test_host1@naver.com', 'test', '양춘식', '000101', '01012345678', '인천시 미추홀구', '1층', '이미지 경로');
INSERT INTO user(user_type, email, password, name, birth, phone_number, address, detail_address, image_path)
VALUES ('HOST', 'test_host2@naver.com', 'test', '김준범', '000101', '01012345678', '인천시 미추홀구', '1층', '이미지 경로');
INSERT INTO user(user_type, email, password, name, birth, phone_number, address, detail_address, image_path)
VALUES ('HOST', 'test_host3@naver.com', 'test', '정은주', '000101', '01012345678', '인천시 미추홀구', '1층', '이미지 경로');
INSERT INTO user(user_type, email, password, name, birth, phone_number, address, detail_address, image_path)
VALUES ('HOST', 'test_host4@naver.com', 'test', '임지영', '000101', '01012345678', '인천시 미추홀구', '1층', '이미지 경로');
INSERT INTO user(user_type, email, password, name, birth, phone_number, address, detail_address, image_path)
VALUES ('HOST', 'test_host5@inha.edu', 'test', '임춘식', '000101', '01012345678', '인천시 미추홀구', '1층', '이미지 경로');
INSERT INTO user(user_type, email, password, name, birth, phone_number, address, detail_address, image_path)
VALUES ('GUEST', 'test_guest@inha.edu', 'test', '테스트 게스트', '000101', '01012345678', '인천시 미추홀구', '1층', '이미지 경로');

INSERT INTO host(rate, user_id, explanation) VALUES ('4.91', 1, '양춘식 호스트 설명');
INSERT INTO host(rate, user_id, explanation) VALUES ('4.91', 2, '김준범 호스트 설명');
INSERT INTO host(rate, user_id, explanation) VALUES ('4.91', 3, '정은주 호스트 설명');
INSERT INTO host(rate, user_id, explanation) VALUES ('4.91', 4, '임지영 호스트 설명');
INSERT INTO host(rate, user_id, explanation) VALUES ('4.91', 5, '임춘식 호스트 설명');

INSERT INTO hashtag(host_id, content) VALUES (1, '양봉 30년차');
INSERT INTO hashtag(host_id, content) VALUES (1, '꿀벌로 강남 건물주');
INSERT INTO hashtag(host_id, content) VALUES (2, '아르키나 과일 재배');
INSERT INTO hashtag(host_id, content) VALUES (2, 'SNS 열풍');
INSERT INTO hashtag(host_id, content) VALUES (3, '배추농사 13년차');
INSERT INTO hashtag(host_id, content) VALUES (3, '겨울철 김장철 매출 6위');
INSERT INTO hashtag(host_id, content) VALUES (4, '백설딸기 재배');
INSERT INTO hashtag(host_id, content) VALUES (4, '요즘 대세');

INSERT INTO farming_holiday(name, location, address, pay, pay_months, main_image_path, detail_image_path, recruit_start_date,
                            recruit_end_date, work_start_date, work_end_date, work_weekday, work_time, recruit_number,
                            apply_number, recruit_status, explanation, lat, lon, rate, host_id)
VALUES ('임실치즈마을 치즈공업', '전라북도 임실군', '전라북도 임실군 임실읍 치즈마을 1길 4 임실치즈마을', 220, 7, '메인 이미지 주소',
        '디테일 이미지 주소', '2023-03-06', '2023-09-01', '2023-09-01', '2024-03-01', '주5일', '9:30-15:00 (12:00-13:00 점심)',
        4, 3, 'ON_GOING', '# 임실치즈마을 리코타치즈 유통', '38', '127', 4.55, 1);

INSERT INTO guest(reviews, worked_days, earnings)
VALUES (17, 173, 420);

INSERT INTO farming_holiday_guest(farming_holiday_id, guest_id, approval_status)
VALUES (1, 1, 'WAITING');

INSERT INTO house(name, location, image_path, rent, rent_months, rent_start_date, rent_end_date, house_type, area,
                  capacity, room_facilities, out_facilities, address, lat, lon, recruit_status, rate, farming_holiday_id, host_id)
VALUES ('전북 임실치즈 전원주택(2/5층)', '전라북도 임실군', '이미지 경로', 10, 6, '2023-08-20', '2024-01-20', '전원주택', 30,
        1, '인터넷,에어컨,가스레인지,TV', '마당, 공용주차장, 바베큐, 파라솔', '전라북도 임실군 임실읍 치즈마을 1길 4 임실치즈마을', '38', '127', 'ON_GOING', 4.35, 1, 1);
