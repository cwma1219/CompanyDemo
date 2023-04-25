# 練習-後端管理系統設計
---
框架：Spring Boot , Spring Data JPA  
資料庫：MySQL

---
API皆使用REST風格設計


| HTTP Request Method | 行為         | 
| -------------       | -------     | 
| GET                 | 查詢         | 
| PUT                 | 修改         |
| DELETE              | 刪除         |
| POST                | 新增         |

所有功能皆須完成登入才可使用，刪除功能需有管理員權限才可執行。

---
#### 回傳格式範例
```json
{
  "code":1,
  "msg":"success",
  "data": {
    "id": 1,
    "name": "硬體部門",
    "createTime": "2023-04-21T15:16:47",
    "updateTime": "2023-04-21T15:16:47"
  }
}
```
前端只需根據此格式進行分析並處理，stc/main/resources/static/index.html為前端Web測試

---
## 部門管理

- 查詢全部部門
```java!
"/depts"
```
- 根據部門ID查詢
```java!
"/depts/{id}"
```
- 查詢部門員工
```java!
"/depts/{id}/staff"
```
- 查詢部門產品
```java!
"/depts/{id}/prod"
```
- 新增部門
```java!
"/depts"
```
- 修改部門
```java!
"/depts"
```
- 刪除部門
```java!
"/depts/{id}"
```
---
## 產品管理
- 根據產品ID查詢
```java!
"/prod/{id}"
```
- 查詢產品
```java!
"/prod"
```
- 新增產品
```java!
"/prod"
```
- 刪除產品
```java!
"/prod"
```
- 修改產品
```java!
"/prod"
```
---
## 員工管理
- 根據員工編號查詢
```java!
"/staff/{id}"
```
- 尋找員工
```java!
"/staff"
```
- 新增員工
```java!
"/staff"
```
- 修改員工
```java!
"/staff"
```
- 刪除員工
```java!
"/staff"
```
