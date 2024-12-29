#!/usr/bin/env bash
echo "Running static analysis..."

#echo "Checking dependency library's version"
#./gradlew dependencyUpdate --daemon
#status0=$?
#if [[ "$status0" = 0 ]] ; then
#    echo "*******************************************************"
#    echo "              Libraries Version checked                "
#    echo "   Please check and update your dependency if needed   "
#    echo "     Check report at \"build/reports/dependencies\"    "
#    echo "*******************************************************"
#else
#    echo "*******************************************************"
#    echo "              Libraries Version failed                 "
#    echo "   Please check and correct the error before commit.   "
#    echo "*******************************************************"
#    exit status0
#fi

echo "Start running ktlint"
./gradlew ktlintFormat ktlintCheck --daemon
status1=$?
if [[ "$status1" = 0 ]] ; then
    echo "*******************************************************"
    echo "             Ktlint runs successfully                  "
    echo "*******************************************************"
else
    echo "*******************************************************"
    echo "                 Ktlint failed                         "
    echo "     Please fix the reported issues before commit.     "
    echo "*******************************************************"
    exit status1
fi

echo "Start running detektCheck"
./gradlew detekt --daemon
status2=$?
if [[ "$status2" = 0 ]] ; then
    echo "*******************************************************"
    echo "             Detekt runs successfully                  "
    echo "*******************************************************"
else
    echo "*******************************************************"
    echo "                 Detekt failed                         "
    echo "   Please fix the reported issues before committing    "
    echo "*******************************************************"
    exit status2
fi

echo "Start running unit test"
./gradlew testDevelopDebugUnitTestCoverage --daemon
status3=$?
if [[ "$status3" = 0 ]] ; then
    echo "*******************************************************"
    echo "                 UnitTest successfully                 "
    echo "*******************************************************"
else
    echo "*******************************************************"
    echo "                   UnitTest failed                     "
    echo "   Please fix the unit test issues before committing   "
    echo "*******************************************************"
    exit status3
fi

# add changed files after run auto format
git add .