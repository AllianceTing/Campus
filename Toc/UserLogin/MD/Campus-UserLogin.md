# Campus-Toc-UserLogin

| Version | Update Time | Status | Author | Description |
|---------|-------------|--------|--------|-------------|
|v2023-02-11 22:27:22|2023-02-11 22:27:22|auto|@Lenovo|Created by smart-doc|



## PROJECT_NAME UserLogin
### 
**URL:** http://39.106.54.125/tcu/user/login

**Type:** POST

**Author:** Alliance github_https://github.com/AllianceTing
DATE 2023/1/29~16:26

**Content-Type:** application/json

**Description:** 

**Query-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|strategyName|enum|true|WeChatLogin()<br/>MailLogin()<br/>MessageLogin()<br/>AccountLogin()<br/>test()<br/>|-|

**Body-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|startDateTime|string|false|No comments found.|-|
|endDateTime|string|false|No comments found.|-|
|userPassword|string|false|No comments found.|-|
|phoneNumber|string|false|No comments found.|-|
|authCode|string|false|No comments found.|-|
|emailCode|string|false|No comments found.|-|
|userAccount|string|false|No comments found.|-|
|avatarUrl|string|false||-|
|gender|int32|false||-|
|phone|string|false||-|
|email|string|false||-|

**Request-example:**
```
curl -X POST -H 'Content-Type: application/json' -i http://39.106.54.125/tcu/user/login?strategyName=WeChatLogin --data '{
  "startDateTime": "2023-02-11 22:27:23",
  "endDateTime": "2023-02-11 22:27:23",
  "userPassword": "g4x7d9",
  "phoneNumber": "k03oh4",
  "authCode": "3757",
  "emailCode": "3757",
  "userAccount": "b6f6mu",
  "avatarUrl": "www.tyesha-parker.io",
  "gender": 0,
  "phone": "1-540-910-9141",
  "email": "gricelda.pacocha@yahoo.com"
}'
```
**Response-fields:**

| Field | Type | Description | Since |
|-------|------|-------------|-------|
|any object|object|any object.|-|

**Response-example:**
```
{}
```

### 
**URL:** http://39.106.54.125/tcu/user/logout

**Type:** POST

**Author:** Alliance github_https://github.com/AllianceTing
DATE 2023/1/29~16:26

**Content-Type:** application/json

**Description:** 

**Body-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|startDateTime|string|false|No comments found.|-|
|endDateTime|string|false|No comments found.|-|
|userPassword|string|false|No comments found.|-|
|phoneNumber|string|false|No comments found.|-|
|authCode|string|false|No comments found.|-|
|emailCode|string|false|No comments found.|-|
|userAccount|string|false|No comments found.|-|
|avatarUrl|string|false||-|
|gender|int32|false||-|
|phone|string|false||-|
|email|string|false||-|

**Request-example:**
```
curl -X POST -H 'Content-Type: application/json' -i http://39.106.54.125/tcu/user/logout --data '{
  "startDateTime": "2023-02-11 22:27:23",
  "endDateTime": "2023-02-11 22:27:23",
  "userPassword": "kt427h",
  "phoneNumber": "8nm859",
  "authCode": "3757",
  "emailCode": "3757",
  "userAccount": "utoh0c",
  "avatarUrl": "www.tyesha-parker.io",
  "gender": 0,
  "phone": "1-540-910-9141",
  "email": "gricelda.pacocha@yahoo.com"
}'
```
**Response-fields:**

| Field | Type | Description | Since |
|-------|------|-------------|-------|
|any object|object|any object.|-|

**Response-example:**
```
{}
```

### 
**URL:** http://39.106.54.125/tcu/user/loginGetMessageCode

**Type:** POST

**Author:** Alliance github_https://github.com/AllianceTing
DATE 2023/1/29~16:26

**Content-Type:** application/x-www-form-urlencoded;charset=UTF-8

**Description:** 

**Query-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|phone|string|true|No comments found.|-|

**Request-example:**
```
curl -X POST -i http://39.106.54.125/tcu/user/loginGetMessageCode --data 'phone=1-540-910-9141'
```
**Response-fields:**

| Field | Type | Description | Since |
|-------|------|-------------|-------|
|any object|object|any object.|-|

**Response-example:**
```
{}
```

### 
**URL:** http://39.106.54.125/tcu/user/loginGetMailCode

**Type:** POST

**Author:** Alliance github_https://github.com/AllianceTing
DATE 2023/1/29~16:26

**Content-Type:** application/x-www-form-urlencoded;charset=UTF-8

**Description:** 

**Query-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|startDateTime|string|false|No comments found.|-|
|endDateTime|string|false|No comments found.|-|
|userPassword|string|false|No comments found.|-|
|phoneNumber|string|false|No comments found.|-|
|authCode|string|false|No comments found.|-|
|emailCode|string|false|No comments found.|-|
|userAccount|string|false|No comments found.|-|
|avatarUrl|string|false||-|
|gender|int32|false||-|
|phone|string|false||-|
|email|string|false||-|

**Request-example:**
```
curl -X POST -i http://39.106.54.125/tcu/user/loginGetMailCode --data 'startDateTime=2023-02-11 22:27:23&endDateTime=2023-02-11 22:27:23&userPassword=0oznd7&phoneNumber=malhbn&authCode=3757&emailCode=3757&userAccount=7twn87&avatarUrl=www.tyesha-parker.io&gender=0&phone=1-540-910-9141&email=gricelda.pacocha@yahoo.com'
```

**Response-example:**
```
Return void.
```

### 
**URL:** http://39.106.54.125/tcu/user/registry

**Type:** POST

**Author:** Alliance github_https://github.com/AllianceTing
DATE 2023/1/29~16:26

**Content-Type:** application/json

**Description:** 

**Body-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|startDateTime|string|false|No comments found.|-|
|endDateTime|string|false|No comments found.|-|
|userAccount|string|false||-|
|userPassword|string|false|No comments found.|-|

**Request-example:**
```
curl -X POST -H 'Content-Type: application/json' -i http://39.106.54.125/tcu/user/registry --data '{
  "startDateTime": "2023-02-11 22:27:23",
  "endDateTime": "2023-02-11 22:27:23",
  "userAccount": "edkush",
  "userPassword": "2t484c"
}'
```
**Response-fields:**

| Field | Type | Description | Since |
|-------|------|-------------|-------|
|any object|object|any object.|-|

**Response-example:**
```
{}
```

## PROJECT_NAME UserRegistry
### ???????????????????????????????????????????????????
**URL:** http://39.106.54.125/tcu/user/register

**Type:** POST

**Author:** Alliance github_https://github.com/AllianceTing
DATE 2023/1/29~22:28

**Content-Type:** application/x-www-form-urlencoded;charset=UTF-8

**Description:** ???????????????????????????????????????????????????

**Query-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|phoneNumber|string|false|No comments found.<br/>Validate[regexp: ^[1][3,4,5,6,7,8,9][0-9]{9}$; ]|-|

**Request-example:**
```
curl -X POST -i http://39.106.54.125/tcu/user/register --data 'phoneNumber=d5ftsj'
```
**Response-fields:**

| Field | Type | Description | Since |
|-------|------|-------------|-------|
|any object|object|any object.|-|

**Response-example:**
```
{}
```

### ?????????????????????????????????
**URL:** http://39.106.54.125/tcu/user/register/authCode

**Type:** POST

**Author:** Alliance github_https://github.com/AllianceTing
DATE 2023/1/29~22:28

**Content-Type:** application/json

**Description:** ?????????????????????????????????

**Body-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|startDateTime|string|false|No comments found.|-|
|endDateTime|string|false|No comments found.|-|
|userPassword|string|false|No comments found.|-|
|phoneNumber|string|false|No comments found.|-|
|authCode|string|false|No comments found.|-|
|emailCode|string|false|No comments found.|-|
|userAccount|string|false|No comments found.|-|
|avatarUrl|string|false||-|
|gender|int32|false||-|
|phone|string|false||-|
|email|string|false||-|

**Request-example:**
```
curl -X POST -H 'Content-Type: application/json' -i http://39.106.54.125/tcu/user/register/authCode?authCode=3757 --data '{
  "startDateTime": "2023-02-11 22:27:23",
  "endDateTime": "2023-02-11 22:27:23",
  "userPassword": "4bmhzd",
  "phoneNumber": "ked6lp",
  "authCode": "3757",
  "emailCode": "3757",
  "userAccount": "ycvpfe",
  "avatarUrl": "www.tyesha-parker.io",
  "gender": 0,
  "phone": "1-540-910-9141",
  "email": "gricelda.pacocha@yahoo.com"
}'
```
**Response-fields:**

| Field | Type | Description | Since |
|-------|------|-------------|-------|
|any object|object|any object.|-|

**Response-example:**
```
{}
```

### ???<br>??????????????????????????????
**URL:** http://39.106.54.125/tcu/user/register/username

**Type:** POST

**Author:** Alliance github_https://github.com/AllianceTing
DATE 2023/1/29~22:28

**Content-Type:** application/x-www-form-urlencoded;charset=UTF-8

**Description:** ???
??????????????????????????????

**Query-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|userAccount|string|true|No comments found.|-|

**Request-example:**
```
curl -X POST -i http://39.106.54.125/tcu/user/register/username --data 'userAccount=u2v10p'
```
**Response-fields:**

| Field | Type | Description | Since |
|-------|------|-------------|-------|
|any object|object|any object.|-|

**Response-example:**
```
{}
```

### ?????????????????????
**URL:** http://39.106.54.125/tcu/user/register/sendUserCode

**Type:** POST

**Author:** Alliance github_https://github.com/AllianceTing
DATE 2023/1/29~22:28

**Content-Type:** application/x-www-form-urlencoded;charset=UTF-8

**Description:** ?????????????????????

**Query-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|email|string|false|No comments found.|-|

**Request-example:**
```
curl -X POST -i http://39.106.54.125/tcu/user/register/sendUserCode --data 'email=gricelda.pacocha@yahoo.com'
```
**Response-fields:**

| Field | Type | Description | Since |
|-------|------|-------------|-------|
|any object|object|any object.|-|

**Response-example:**
```
{}
```


