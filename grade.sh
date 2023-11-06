CPATH='.;lib/hamcrest-core-1.3.jar;lib/junit-4.13.2.jar'

rm -rf student-submission
rm -rf grading-area

mkdir grading-area

git clone $1 student-submission
echo 'Finished cloning'


# Draw a picture/take notes on the directory structure that's set up after
# getting to this point

# Then, add here code to compile and run, and do any post-processing of the
# tests

if [ ! -f "student-submission/ListExamples.java" ]
then
    echo "Required file not in respository, need ListExamples.java"
    exit 1
fi

cp student-submission/ListExamples.java grading-area/
cp TestListExamples.java grading-area/

javac -cp "$CPATH" grading-area/*.java 2> errors.txt

if [ $? -ne 0 ]
then
    echo "Compilation failed. Check for syntax errors below:"
    echo ""
    cat errors.txt
    exit 1
fi

java -cp "$CPATH;grading-area" org.junit.runner.JUnitCore TestListExamples > testOutput.txt
cat testOutput.txt
#if [grep "FAILURES!!!" testOutput.txt ]
