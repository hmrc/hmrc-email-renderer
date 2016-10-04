# hmrc-email-renderer


[![Build Status](https://travis-ci.org/hmrc/hmrc-email-renderer.svg)](https://travis-ci.org/hmrc/hmrc-email-renderer) [ ![Download](https://api.bintray.com/packages/hmrc/releases/hmrc-email-renderer/images/download.svg) ](https://bintray.com/hmrc/releases/hmrc-email-renderer/_latestVersion)


Manages the rendering of parameterised email using templates. 
## API

| Path                         | Supported Methods | Description  |
| ---------------------------- | ----------------  | ------------ |
| ```/templates/:templateId``` | POST              | Renders the email template for the  given template ID[More...](#post-templatestemplateId) |


### POST /templates/:templateId

Renders the email template for the  given template ID and returns the rendered template details.

Example request body - parameters with String type key and values.

```json
{
  "parameters": {
    "param1" : "Parameter to be used in the email template"
    "param2" : "Parameter to be used in the email template"
  }
}
```

Responds with status:

* 200 When the template is rendered successfully

 ```json
{
    "plain": "Rendered template in text format",
    "html": "Rendered template in HTML format",
    "fromAddress": "From address to be used for this email when sending",
    "subject": "Email subject to use", 
    "service": "The regime (i.e. - sa/paye/etc) that this template belongs to"
}
 ```
* 404 When the template with the provided ID cannot be resolved.
 
* 400 When an insufficient set of parameters for rendering the template is specified in the request. Only the first missing value is reported.

 ```json
{
    "status": "Rendering of template failed",
    "reason": "key not found: param10"
}
 ```

### License

This code is open source software licensed under the [Apache 2.0 License]("http://www.apache.org/licenses/LICENSE-2.0.html")