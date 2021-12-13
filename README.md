# hmrc-email-renderer
***

[![Build Status](https://travis-ci.org/hmrc/hmrc-email-renderer.svg)](https://travis-ci.org/hmrc/hmrc-email-renderer) [ ![Download](https://api.bintray.com/packages/hmrc/releases/hmrc-email-renderer/images/download.svg) ](https://bintray.com/hmrc/releases/hmrc-email-renderer/_latestVersion)



Manages the rendering of parameterised email using templates. 

## Before requesting to merge your PR, please ensure that you have re-based with main
| **Note: Before sending a pull request with template changes, please look at our [guidelines](/CONTRIBUTING.md).** |
| --- |


## How to deal with pull requests for transactional email templates
| **DC Team Note: Before accepting a PR and merging, please ensure you read through the following [acceptance criteria](https://confluence.tools.tax.service.gov.uk/display/DCT/Pull+request+acceptance+criteria).** |
| --- |

| **Follow these instructions: [How to deal with pull requests for transactional email templates](https://confluence.tools.tax.service.gov.uk/display/DCT/How+to+deal+with+pull+requests+for+transactional+email+templates)** |
| --- |

## API

| Path                         | Supported Methods | Description  |
| ---------------------------- | ----------------  | ------------ |
| ```/templates/:templateId``` | POST              | Renders the email template for the given template Id [More...](#post-templatestemplateId) |


### POST /templates/:templateId

Renders the email template for the  given template Id and returns the rendered template details.

Example request body - parameters with String type key and values.

```json
{
  "parameters": {
    "param1" : "Parameter to be used in the email template",
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
* 404 When the template with the provided template Id cannot be resolved.
 
* 400 When an insufficient set of parameters for rendering the template is specified in the request. Only the first missing mandatory value is reported.  

See the [How to add a template](CONTRIBUTING.md#how-to-add-a-template) section to see the distinction between optional and mandatory parameters.

 ```json
{
    "status": "Rendering of template failed",
    "reason": "key not found: param10"
}
 ```

### Preview Mode

Templates can be fiddly to get right as they can ordinarily only be viewed by actually generating an email and sending it. To work around this you can preview templates **during development** by running the micro-service from sbt:

```bash
cd $WORKSPACE/hmrc-email-renderer
sbt -Dhttp.port=8950 -Dapplication.router=testOnlyDoNotUseInAppConf.Routes run
```

You should be able to list all the templates available for preview from [http://localhost:8950/hmrc-email-renderer/test-only/preview](http://localhost:8950/hmrc-email-renderer/test-only/preview).

Note that to render logos correctly the assets frontend also needs to be started using

```bash
sm --start ASSETS_FRONTEND -f
```

#### Quick Preview
Alternatively, you can do a preview of emails by starting the service using `sm` to preview the source, snapshot or release versions of the micro-service.

```bash
sm --start ASSETS_FRONTEND -r
sm --start HMRC_EMAIL_RENDERER [-f|-r]
```

Again, list the templates can then be previewed from

[http://localhost:8950/hmrc-email-renderer/test-only/preview](http://localhost:8950/hmrc-email-renderer/test-only/preview)

### Handling Templates based on Language preference
If we want to make a template to work based on preference. 

We have to add this to configuration in following place

[https://github.com/hmrc/app-config-base/blob/master/hmrc-email-renderer.conf](https://github.com/hmrc/app-config-base/blob/master/hmrc-email-renderer.conf)

key should be an english templateId and value should be a Welsh templateId

We make a call to preferences service to see whether language is set to *English* or *Welsh*, if *Welsh* we return welsh template otherwise english.


### License

This code is open source software licensed under the [Apache 2.0 License]("http://www.apache.org/licenses/LICENSE-2.0.html")
