# Project using Serenity Screenplay

## Setup project

*Điều kiện tiên quyết*
- Cài đặt Java 8 trở lên
- Sử dụng Maven từ 3.5 trở lên
- Dùng IDE tùy chọn (recommend chọn Intellij IDEA)

## Project Structure

+ ability
  Add custom abilities
+ model
  Domain model classes
+ task
  Business-level tasks
+ interaction
  UI interactions
+ ui
  Page Objects and Page Elements
+ question
  Objects used to query the application


## How to run test on local

- Compile code (không cần chạy lệnh này khi chạy các lệnh test)

`mvn clean test-compile`

- Run toàn bộ test cases

`mvn clean verify`

- Run Test theo Tags

`mvn clean verify -Dtags="tagName"`

- Run Test theo environment (xem environment trong file src/test/resources/serenity.conf)

`mvn clean verify -Denvironment="environmentName"`

- Run Test với language (xem default language trong file pom.xml)

`mvn clean verify -Dlanguage=vi


## How to run test on jenkins

- Run toàn bộ test cases

`mvn clean verify -Denvironment="allinone"`


## Reporting

The Serenity reports will be generated in the `target/site/serenity` directory.

- full report: `target/site/serenity/index.html`
- Single page summary report: `target/site/serenity/serenity-summary.html`

## Git branch name

Format: `<jira-task>-(<com.demo.features>)-<short-task-name>`

#### Example

VEDR-3016-group-create
^-------^ ^---^ ^----^
|           |      |+-> task name in short form
|           |
|           +-> com.demo.features
|
+-------> Jira task




## Semantic Commit Messages


Format: `<type>(<scope>): <subject>`

`<scope>` is optional

#### Example


test: update policy
^--^  ^------------^
|     |
|     +-> Summary in present tense.
|
+-------> Type: docs, fix, refactor, style or test.


More Examples:

- `feat`: adding new com.demo.features, eg: support multi languages, support OAuth2
- `test`: adding tests
- `fix`: bug fix for test script, or configuration; eg: update test name, change assertion
- `docs`: changes to the documentation
- `style`: formatting, missing semi colons, etc
- `refactor`: refactoring code, eg. renaming a variable