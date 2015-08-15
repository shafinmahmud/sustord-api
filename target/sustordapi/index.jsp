<html>
    <body>
        <h2>SUSTORD Web API!</h2>
        <h3>Here is some demo that explains how to create the URIs</h3>
        <p>For making a Student <b>Login</b> request, the URI pattern is
            <i>api/student/login/{registration_no}/{password}</i>
            <a href="api/student/login/2011331001/123456">demo</a>
        <p>
        <p>For making a Student <b>Personal Profile</b> request, the URI pattern is
            <i>api/student/profile/personal/{registration_no}/</i>
            <a href="api/student/profile/personal/2011331001">demo</a>
        <p>
        <p>For making a Student <b>Academic Profile</b> request, the URI pattern is
            <i>api/student/profile/academic/{registration_no}/</i>
            <a href="api/student/profile/academic/2011331001">demo</a>
        <p>
        <p>For making a  <b>Syllabus of semester</b> request, the URI pattern is
            <i>api/student/syllabus/{batch_tag}/{semester_no}/</i>
            <a href="api/student/syllabus/SUST2011331/1">demo</a>
        <p>
        <p>
        <p>For making a  <b>Content of syllabus</b> request, the URI pattern is
            <i>api/student/syllabus/details/{batch_tag}/{semester_no}/</i>
            <a href="api/student/syllabus/details/SUST2011331/1">demo</a>
        <p>
        <p>For making a  <b>Course details</b> request, the URI pattern is
            <i>api/student/syllabus/details/{course_code}/</i>
            <a href="api/student/syllabus/details/cse133">demo</a>
        <p>

        <p>For making a Student <b>Semester Result</b> request, the URI pattern is
            <i>api/student/result/semester/{semester_no}/{registration_no}/</i>
            <a href="api/student/result/semester/1/2011331001">demo</a>
        <p>
        <p>For making a Student <b>Curriculum Result</b> request, the URI pattern is
            <i>api/student/result/curriculum/{semester_no}{registration_no}/</i>
            <a href="api/student/result/curriculum/1/2011331001">demo</a>
        <p>
        <p>For making a Student <b>Cumulative Result</b> request, the URI pattern is
            <i>api/student/result/cgpa/{registration_no}/</i>
            <a href="api/student/result/cgpa/2011331001">demo</a>
        <p>
            Visit our live project <a href="http://cloud.scdnlab.com:8080/sustord/">
                here</a>!
    </body>
</html>
