Meta:
@author xiaopeng.cai
@theme student
Narrative:
In order to get a new student,as a teacher, I want to add a student into the Class

Scenario: Add a student into the class
Given There is a student
And his name is 'Sean'
And his age is '18'
And his hobby is 'basketball'
And his father's name is 'Mike'
And his mother's name is 'Mary'
And his brother's name is 'Luis'
When system add the student 'Sean' into classRoom
Then we can get student 'Sean' from classRoom