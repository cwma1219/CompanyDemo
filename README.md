# 公司管理後端
---
API皆使用REST風格設計


| HTTP Request Method | 行為      | 
| -------------       | -------- | 
| GET                 | 查詢     | 
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
---
## 部門管理 

- 查詢全部門
```java!
"/depts"
```
- 部門ID查詢
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
- 產品ID查詢
```java!
"/prod/{id}"
```
- 自訂條件查詢產品
```java!
"/prod"
```
- 查詢負責部門
```java!
"/prod/{id}"
```
- 新增產品
```java!
"/prod"
```
- 修改產品
```java!
"/prod"
```
---
## 員工管理
- 根據員工編號搜索
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
