# USE CASE: 2 Produce a report of all employee's salaries in a given department.

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *HR advisor* I want to *produce a report on the salary of all employees in my department* so that *I can support financial reporting for my department.*

### Scope

Company.

### Level

Primary task.

### Preconditions

Department is known and stored in the database.

### Success End Condition

A report is available for HR to provide to finance.

### Failed End Condition

No report is produced.

### Primary Actor

HR Advisor.

### Trigger

A request for finance information is sent to HR.

## MAIN SUCCESS SCENARIO

1. Finance request salary information for all employees in a given department.
2. HR advisor captures the department to retrieve the salaries from.
3. HR advisor extracts current salary information of all employees working in the given department.
4. HR advisor provides report to finance.

## EXTENSIONS

2. **Department does not exist**:
    1. HR advisor informs finance no role exists.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0