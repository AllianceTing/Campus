# Campus-Toc-UserLogin

| Version | Update Time | Status | Author | Description |
|---------|-------------|--------|--------|-------------|
|v2023-02-11 12:31:47|2023-02-11 12:31:47|auto|@Lenovo|Created by smart-doc|



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
  "startDateTime": "2023-02-11 12:31:48",
  "endDateTime": "2023-02-11 12:31:48",
  "userPassword": "ebhqhl",
  "phoneNumber": "kxj9yw",
  "authCode": "17082",
  "emailCode": "17082",
  "userAccount": "5pnajk",
  "avatarUrl": "www.stacy-wehner.org",
  "gender": 0,
  "phone": "(925) 212-9888",
  "email": "rickie.hoeger@gmail.com"
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
  "startDateTime": "2023-02-11 12:31:48",
  "endDateTime": "2023-02-11 12:31:48",
  "userPassword": "otwha3",
  "phoneNumber": "vlgtwb",
  "authCode": "17082",
  "emailCode": "17082",
  "userAccount": "qd6jbe",
  "avatarUrl": "www.stacy-wehner.org",
  "gender": 0,
  "phone": "(925) 212-9888",
  "email": "rickie.hoeger@gmail.com"
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
curl -X POST -i http://39.106.54.125/tcu/user/loginGetMessageCode --data 'phone=(925) 212-9888'
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
curl -X POST -i http://39.106.54.125/tcu/user/loginGetMailCode --data 'startDateTime=2023-02-11 12:31:48&endDateTime=2023-02-11 12:31:48&userPassword=gukljn&phoneNumber=4hzy6w&authCode=17082&emailCode=17082&userAccount=7d1kz9&avatarUrl=www.stacy-wehner.org&gender=0&phone=(925) 212-9888&email=rickie.hoeger@gmail.com'
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
  "startDateTime": "2023-02-11 12:31:48",
  "endDateTime": "2023-02-11 12:31:48",
  "userAccount": "uyfo70",
  "userPassword": "vbehsd"
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
### 校验手机号格式并且发送信息验证码。
**URL:** http://39.106.54.125/tcu/user/register

**Type:** POST

**Author:** Alliance github_https://github.com/AllianceTing
DATE 2023/1/29~22:28

**Content-Type:** application/x-www-form-urlencoded;charset=UTF-8

**Description:** 校验手机号格式并且发送信息验证码。

**Query-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|phoneNumber|string|false|No comments found.<br/>Validate[regexp: ^[1][3,4,5,6,7,8,9][0-9]{9}$; ]|-|

**Request-example:**
```
curl -X POST -i http://39.106.54.125/tcu/user/register --data 'phoneNumber=h8ggf6'
```
**Response-fields:**

| Field | Type | Description | Since |
|-------|------|-------------|-------|
|any object|object|any object.|-|

**Response-example:**
```
{}
```

### 校验信息验证码是否正确
**URL:** http://39.106.54.125/tcu/user/register/authCode

**Type:** POST

**Author:** Alliance github_https://github.com/AllianceTing
DATE 2023/1/29~22:28

**Content-Type:** application/json

**Description:** 校验信息验证码是否正确

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
curl -X POST -H 'Content-Type: application/json' -i http://39.106.54.125/tcu/user/register/authCode?authCode=17082 --data '{
  "startDateTime": "2023-02-11 12:31:48",
  "endDateTime": "2023-02-11 12:31:48",
  "userPassword": "bny299",
  "phoneNumber": "rdhrmg",
  "authCode": "17082",
  "emailCode": "17082",
  "userAccount": "xomedo",
  "avatarUrl": "www.stacy-wehner.org",
  "gender": 0,
  "phone": "(925) 212-9888",
  "email": "rickie.hoeger@gmail.com"
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

### 】<br>判断账户是否已经使用
**URL:** http://39.106.54.125/tcu/user/register/username

**Type:** POST

**Author:** Alliance github_https://github.com/AllianceTing
DATE 2023/1/29~22:28

**Content-Type:** application/x-www-form-urlencoded;charset=UTF-8

**Description:** 】
判断账户是否已经使用

**Query-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|userAccount|string|true|No comments found.|-|

**Request-example:**
```
curl -X POST -i http://39.106.54.125/tcu/user/register/username --data 'userAccount=rejrwl'
```
**Response-fields:**

| Field | Type | Description | Since |
|-------|------|-------------|-------|
|any object|object|any object.|-|

**Response-example:**
```
{}
```

### 发送邮件验证码
**URL:** http://39.106.54.125/tcu/user/register/sendUserCode

**Type:** POST

**Author:** Alliance github_https://github.com/AllianceTing
DATE 2023/1/29~22:28

**Content-Type:** application/x-www-form-urlencoded;charset=UTF-8

**Description:** 发送邮件验证码

**Query-parameters:**

| Parameter | Type | Required | Description | Since |
|-----------|------|----------|-------------|-------|
|email|string|false|No comments found.|-|

**Request-example:**
```
curl -X POST -i http://39.106.54.125/tcu/user/register/sendUserCode --data 'email=rickie.hoeger@gmail.com'
```
**Response-fields:**

| Field | Type | Description | Since |
|-------|------|-------------|-------|
|any object|object|any object.|-|

**Response-example:**
```
{}
```


