# MDTP Contributor Guidelines

Hello! Thank you for taking the time to contribute to the [HMRC Multichannel Digital Tax Platform](https://hmrc.github.io) (MDTP).

Every service or library on the MDTP is owned by a single team, in order to ensure no central repositories and/or teams constrain service delivery. Therefore this page describes the process for an individual or a team (the "Pull Requestor") to contribute to a repository (the "Repository") belonging to another team (the "Owning Team"). 

The contribution process is twofold: 
- MDTP Guidelines: uniform guidelines applying to all repositories
- Repository Guidelines: contextual guidelines for a specific repository

It is the responsibility of both the Pull Requestor and Owning Team to follow these guidelines. If the Pull Requestor does not follow these guidelines, the Owning Team will reject the changes and may resist future Pull Requests. 

> It is important to remember that an Issue and a Pull Request are a placeholder for a conversation between the Pull Requestor and the Owning Team - people and interactions are important than processes and tools. The Pull Requestor should contact the Owning Team as soon as changes to the Repository are considered.

## I have created a pull request - now what?

Once you've got your code changes done and a pull request created, it's time to get it pushed to production. Here's how:

1. Run the [preview mode](/README.md#preview-development) application on your local development environment to ensure that your template renders properly
2. Create a story for project "Digital Contact (DC)" in Jira with details of the pull request and what it's for
3. Tag our scrum-master [~chris.selby] in the ticket, so we can get it prioritised for you
4. Join Slack channel #team-digital-contact to ask about progress and/or ask questions
5. Our QA's will contact you when the they have merged and deployed to QA so you can check your happy before we create a release ticket

## MDTP Guidelines 

1. The Pull Requestor forks the Repository and makes the proposed changes - including new tests
2. The Pull Requestor runs the Repository build locally and ensures all tests pass
3. The Pull Requestor pushes their changes to their branch and raises a Pull Request against the Repository Issue
4. The Owning Team informs the Pull Requestor:
    1. If the proposed change is unnecessary i.e. if the Repository already supports the desired outcome
    2. If the proposed change is undesirable e.g. rejected in the past from a different Pull Requestor
    3. If the proposed change can be reviewed and released into production in a timeline acceptable to both the Pull Requestor and the Owning Team
5. The Owning Team reviews the Pull Request according to the following criteria:
    1. Can the changes be compiled and tested?
    2. Do the changes clearly indicate what they are trying to achieve?
    2. Are the changes aligned with our coding standards and our architectural approach?
    3. Are the changes compatible with other in-flight changes to the Repository?
    4. Do the changes introduec any new operational concerns e.g. performance, security?
6. The Owning Team accepts or rejects the Pull Request
7. If rejected, the Pull Requestor asks the Owning Team for feedback
8. If accepted, the Owning Team merges the changes into the Repository and creates a new release
9. The Pull Requestor and Owning Team discuss the optimal timing of pre-production and production releases
10. The Owning Team release the changes into the relevant pre-production environment(s)
11. The Pull Requestor and Owning Team validate the functional and operational impact in pre-production
12. The Owning Team schedules a release of the changes into production
13. The Pull Requestor and Owning Team validate the functional and operational impact in production

## Repository Guidelines

Please review these guidelines carefully before submitting new or changed hmrc email templates. They're here to protect HMRC's email from being marked as spam. If you don't, your pull request will probably be rejected. 

## How to add a template

If you'd like to add a template to the hmrc email template service, then:

1. Create an XXXTemplates object in your new folder (under templates folder) e.g. DigitalContactTemplates
2. If it doesn't already exist, create a new service identifier for your regime and add a new entry in templateGroups in the `TemplateLocator` scala file.
4. Create two templates for rendering your message :
  * `.scala.txt` for the plain-text version
  * `.scala.html` for the html version
4. Add a new `MessageTemplate` in your XXXTemplates object: 
  * If you just have a static template, you can use `MessageTemplate`. 
5. That's it!

## Content recommendations

One of our priorities is to make sure that the content of our emails doesn't lead the user to mark the messatge as spam. Here are some recommendations we came up with:

* **Salutation in the email**: if the data is available in your service, it's good to include a salutation at the beginning of the email (e.g. Dear Mr. John Smith...)
* **Avoid using acronyms**: in the message body make sure you are using the full name (e.g. "Self Assessment" instead of "SA")
* When closing a message, **specify your identity within the HMRC organisation**: we usually recommend a closing line that looks like: https://github.com/hmrc/hmrc-email-renderer/blob/master/app/uk/gov/hmrc/hmrcemailrenderer/templates/digitalcontact/newMessageAlertSA316_A_detailed.scala.html#L10  It is important to clearly identify the sender as much as possible. It's strongly discouraged the closing form "from HMRC".
* Help the user understanding **why he's receiving the message**: we use to add some information about why they are receiving this email, it helps to avoid the recipient to mark it as spam, for example: https://github.com/hmrc/hmrc-email-renderer/blob/master/app/uk/gov/hmrc/hmrcemailrenderer/templates/digitalcontact/newMessageAlertSA316_A_detailed.scala.html#L8-L9
* Last but not least: **review the content** for typos or grammar mistakes.

## Links in templates

For security reasons, it is currently **HMRC policy that there are no links in emails**, either in HTML or plain text, hyperlinked or not.

This is because there is no guaranteed way to stop an email reader, plain text or HTML based, from spotting a http://wherever.com/some-url link and turning it into a hyperlink - this has been researched extensively. The only permissible exception to this under policy is verification links, which are vital for proving a customer's address.

## Sending Volumes

It's also really important to **discuss with the DC team how many messages you expect to send, and when.** We monitor the flow of email very carefully to ensure that deliverability of HMRC email is a good as it can be.

## Checklist

* That your template ID is descriptive and doesn't contain the words 'template' or 'id'.
  * Good: `sa_alert_sa316_current_year`
  * Not so good: `sa_message_template_id`
* The names of your template `.scala.html`/`.scala.txt` files match the template ID
* Your template uses:
  * the standard main template for `.html` 
  * the standard footer for `.txt` - watch out for blank lines at the top of these too
* Your code is up to date with current `master`
* That `sbt clean test it:test` passes happily
* Your templates look right when rendered - use the [preview mode](/README.md#preview-development)
* **Note: we will fail any PR with failing tests.**
