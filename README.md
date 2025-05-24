# OpenAPI definition
## Version: v0

### /patients/{id}

#### GET
##### Summary:

Get Details for Single Patient Based on id

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| id | path |  | Yes | string (uuid) |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

#### PUT
##### Summary:

Update a Patient

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| id | path |  | Yes | string (uuid) |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

#### DELETE
##### Summary:

Delete a Patient

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| id | path |  | Yes | string (uuid) |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /patients

#### GET
##### Summary:

Get Details of All Patients

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

#### POST
##### Summary:

Create a New Patient

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |

### /patients/hello

#### GET
##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | OK |


[View API Documentation](https://petstore.swagger.io/?url=https://raw.githubusercontent.com/vaibhav25-mnnit/patient_service/openapi.yaml)

you can also view the api documentation
http://localhost:4000/v3/api-docs
heere once service starts