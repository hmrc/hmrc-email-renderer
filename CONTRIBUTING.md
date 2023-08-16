# Contributor Guidelines

Hello! If you are reading this, it is probably because you want to send emails.  
This page describes the process for a team to submit new or changed email templates. 

Please review these guidelines carefully before submitting a Pull Request. 
They're here to protect HMRC's email from being marked as spam. If you don't, your pull request will probably be rejected. 

If you are unsure on how to make the Pull Request please have a look at the [MDTP Contributor Guidelines](https://github.com/hmrc/mdtp-contributor-guidelines/blob/master/CONTRIBUTING.md)

## How to submit new or changed email template - Checklist 

1. Write the content for your email. One of your priorities should be to make sure that the email is not marked as spam by the user. See our [Content recommendations](#content-recommendations)
2. Decide what is the most suitable priority for the template. See our [Volumes and priority recommendations](#volumes-and-priority-recommendations)
3. Fork this repository and make the necessary code changes. See [How to add a template](#how-to-add-a-template)
4. Verify that your template looks right when rendered - use the [preview mode](/README.md#preview-mode)
5. Run the tests locally with `sbt fmt clean test it:test`
6. Submit a Pull Request and [let the Digital Contact team know](#i-have-created-a-pull-request---now-what)

### I have created a pull request - now what?

Once you've got your code changes done and a pull request created, it's time to get it pushed to production. Here's how:

1. Create a JIRA ticket for project "Digital Contact (DC)" in Jira with details of the pull request and what it's for.  Select "DC Email Templates" in theJira ticket Component/s field
2. Make sure you've attached the [rendered preview of your email](/README.md#preview-mode)
3. Tag Charlie Goff-Deakins [~charlie.goff-deakins] in the ticket, so we can review and get it prioritised for you
4. Join Slack channel #team-digital-contact to tell us you've created a ticket, and also ask about progress or any other questions
5. Because the process makes backing out individual changes complicated, we'll work with you to make sure your email content is production-ready before promoting to our QA environment.
6. Our QA will contact you when they have merged and deployed to the QA environment so you can check you are happy before we create a release ticket


### Content recommendations

One of our priorities is to make sure that the content of our emails doesn't lead the user to mark the message as spam. Here are some recommendations we came up with:

![Alt text](doc/content_guidelines.png?raw=true "Content guidelines")

1. This is the only part of the template that can be customized 
2. Title should clearly indicate the purpose of the email
3. **Salutation in the email**: If the data is available in your service, please include a salutation at the beginning of the email (e.g. Dear Mr Rich The Cat ...)
4. **Avoid using acronyms**: Throughout the message body please make sure you are using the full name (e.g. "Self Assessment" instead of "SA")
5. Help the user understand **why he's receiving the message**: Information about why the user is receiving the email prevents marking the email as spam
6. When closing a message, **specify your identity within the HMRC organisation**: It is important to clearly identify the sender. For example, "From HMRC Self Assessment". Please do not use "From HMRC" to end the message.
7. Last but not least: **Review the content** for typos and grammar mistakes


#### Links in templates

For security reasons, it is currently **HMRC policy that there are no links in emails**, either in HTML or plain text, hyperlinked or not.

This is because there is no guaranteed way to stop an email reader, plain text or HTML based, from spotting a http://wherever.com/some-url link and turning it into a hyperlink - this has been researched extensively. The only permissible exception to this under policy is verification links, which are vital for proving a customer's address.

#### Placeholder template for testing
It is possible that you need to have your template available for testing but you haven't finalised the template content yet.  
If that is the case we are willing to merge your Pull Request as long as there is a line right after the title (point 2 in the above image) that advises the user about it.
For example:
```html
<h4>This is a test email only. Should you receive this email please ignore it</h4>
```

### Volumes and priority recommendations

As explained in the `email` service documentation, the developer can specify for each template use case, which is the most suitable priority: urgent, background or standard:

- **Urgent** priority: all emails will be sent immediately (meaning that no throttling is applied). For this reason, this priority is typically used for **transactional/verification emails**, or whenever the client system expects the user to receive an email promptly. This is **not** meant to be used **for batches**.
- **Standard** priority: this is used to process **batches of emails**, and is the priority that will be used if no other is specified. An email sent with this priority could be queued for a few hours, depending on the load and throttling rate.
- **Background** priority: the typical use case for this is when, from a business point of view, **big batches** (hundred of thousands) of emails need to be sent. An email sent with this priority could be queued for a few days, depending on the load and throttling rate.

It's also really important to **discuss with the Digital Contact team how many messages you expect to send, and when.** We monitor the flow of email very carefully to ensure that deliverability of HMRC email is a good as it can be.


### How to add a template

If you'd like to add a template to the hmrc email template service, then:

1. Create an XXXTemplates object in your new folder (under templates folder) e.g. DigitalContactTemplates
2. If it doesn't already exist, create a new service identifier for your service and add a new entry in templateGroups in the `TemplateLocator` scala file.
4. Create two templates for rendering your message :
  * `.scala.txt` for the plain-text version
  * `.scala.html` for the html version
  Your template ID must be descriptive and should not contain the words 'template' or 'id'. (EG: Good: `sa_alert_sa316_current_year`, Not so good: `sa_message_template_id`)
  The names of your template files must match the template ID
4. Add a new `MessageTemplate` in your XXXTemplates object: 
  * If you just have a static template, you can use `MessageTemplate`. 
5. Add the content to your new template, making sure that your template uses the standard main template for `.html` and the standard footer for `.txt`

##### Example of html template:
```
@(params: Map[String, Any])
@uk.gov.hmrc.hmrcemailrenderer.templates.helpers.html.template_main(params, "You’ve got a new message from HMRC") {
@uk.gov.hmrc.hmrcemailrenderer.templates.helpers.html.salutation(params)
<p style="margin: 0 0 30px; font-size: 19px;">You have a new message from HMRC about Self Assessment.</p>
<p style="margin: 0 0 30px; font-size: 19px;">To view it, sign in to your HMRC online account.</p>
<p style="margin: 0 0 30px; font-size: 19px;">For security reasons, we have not included a link with this email.</p>
<h2 id="why-you-got-this-email" style="margin: 0 0 30px; font-size: 24px;">Why you got this email</h2>
<p style="margin: 0 0 30px; font-size: 19px;">You chose to get paperless notifications instead of letters by post.</p>
<p style="margin: 0 0 30px; font-size: 19px;">This means we send you an email to let you know you have a new message in your account.</p>
<p style="margin: 0 0 30px; font-size: 19px;">From HMRC Self Assessment</p>
}
```

##### Example of txt template:
NOTE: that there is no return character after the parameters.
```
@(params: Map[String, Any])You’ve got a new message from HMRC

@uk.gov.hmrc.hmrcemailrenderer.templates.helpers.txt.salutation(params)

You have a new message from HMRC about Self Assessment.

To view it, sign in to your HMRC online account.

For security reasons, we have not included a link with this email.

Why you got this email

You chose to get paperless notifications instead of letters by post.

This means we send you an email to let you know you have a new message in your account.

From HMRC Self Assessment

@{uk.gov.hmrc.hmrcemailrenderer.templates.helpers.txt.template_footer()}
```

##### Mandatory and Optional parameters

Both `Html` and `Txt` templates take a `Map[String, Any]` as parameter.
The way you access this `Map` of parameters determines whether the parameters are optional or mandatory.

**Mandatory Parameters**

To access mandatory parameters you can use the `.apply()` or the shorthand `()` on `Map[String, Any]`.
```
@(params: Map[String, Any])

This is my mandatory parameter @params("param1").
```

When a mandatory parameters is missing - the [`/tempate/:templateId`](README.md#post-templatestemplateid) endpoint
will return `Bad Request`.

**Optional Parameters**

To access optional parameters, you can use the `.getOrElse` or `.get` method on the `Map[String, Any]`
```
@(params: Map[String, Any])

This is my optional parameter @params.getOrElse("param1", "default value").
```
*Note:* Because `None` get silently displayed as an empty string `""` we recommend to favour `.getOrElse` instead of `.get` or
to make the parameter mandatory.


