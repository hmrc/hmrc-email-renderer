# HMRC Email Renderer

# Overview
Renders parameterised email body content in either HTML or plain text given a template.

- [Digital Contact Runbook](https://confluence.tools.tax.service.gov.uk/display/DCT/Digital+Contact+Runbook)
- [Digital Contact Confluence home page](https://confluence.tools.tax.service.gov.uk/pages/viewpage.action?spaceKey=DCT&title=Digital+Contact)
- [Digital Contact Slack channel - #team-digital-contact](https://hmrcdigital.slack.com/archives/C0J85LC3W)


# Integration
If you're not a member of the Digital Contact team and you need to add or edit a template, typically you will fork this repo.
Please see detailed information in `CONTRIBUTING.md`.

## Preview Mode
Templates can be challenging as they can ordinarily only be viewed by actually generating an email and sending it. To work around this you can preview templates **during development** by running the micro-service from sbt:

```bash
# if you have already forked the repo pls run these git commands otherwise you will
# get an error related to majorVersion below
# java.lang.IllegalArgumentException: Invalid majorVersion: 2. You cannot request a major version of 2 if there are no tags in the repository
git remote add upstream git@github.com:hmrc/hmrc-email-renderer.git  
git fetch upstream 
cd $WORKSPACE/hmrc-email-renderer
sbt -Dhttp.port=8950 -Dapplication.router=testOnlyDoNotUseInAppConf.Routes run
```

You should be able to list all the templates available for preview from [http://localhost:8950/hmrc-email-renderer/test-only/preview](http://localhost:8950/hmrc-email-renderer/test-only/preview).

Note that to render logos correctly the assets frontend also needs to be started using `ASSETS_FRONTEND` service manager profile.

## Quick Preview
Alternatively, you can do a preview of emails by starting the service using service-manager to preview the source, snapshot or release versions of the micro-service. Start both the `ASSETS_FRONTEND` and `HMRC_EMAIL_RENDERER` profiles.

Templates can then be previewed from
[http://localhost:8950/hmrc-email-renderer/test-only/preview](http://localhost:8950/hmrc-email-renderer/test-only/preview)

## Handling Templates based on Language preference
If we want to make a template to work based on preference.
We have to add this to configuration in following place

[https://github.com/hmrc/app-config-base/blob/master/hmrc-email-renderer.conf](https://github.com/hmrc/app-config-base/blob/master/hmrc-email-renderer.conf)

key should be an english templateId and value should be a Welsh templateId

The `preferences` service is queried to look up the language preference - *English* or *Welsh* and the appropriate template is selected.


## Template Pull Requests
Follow these instructions: [How to deal with pull requests for transactional email templates](https://confluence.tools.tax.service.gov.uk/display/DCT/How+to+deal+with+pull+requests+for+transactional+email+templates)


# Developer Information

## API Endpoints
The Digital Contact `email` service calls `hmrc-email-renderer` with a template name in the URL path.

| Path                     | Supported Methods  | Description                                                                               |
|--------------------------|--------------------|-------------------------------------------------------------------------------------------|
| `/templates/:templateId` | POST               | Renders the email template for the given template Id [More...](#post-templatestemplateId) |


### POST /templates/:templateId
Renders the email template for the given template Id and returns the rendered template details.

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



## SBT Tasks
```bash
# Format the code
sbt fmt

# Run the tests and a coverage report
sbt clean coverage test coverageReport
```


### License
This code is open source software licensed under the [Apache 2.0 License]("http://www.apache.org/licenses/LICENSE-2.0.html")
