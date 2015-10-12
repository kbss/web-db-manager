var gulp = require('gulp');
var concat = require('gulp-concat');
var uglify = require('gulp-uglify');
var ngAnnotate = require('gulp-ng-annotate');
var sass = require('gulp-sass');
var merge = require('gulp-merge');
var changed = require('gulp-changed');
var rename = require('gulp-rename');
var ngmin = require('gulp-ngmin');
var minifyHTML = require('gulp-minify-html');

var pkg = require('./package.json');

function getDate(args) {
    var date = new Date(),
        append = {},
        result = [];
    ['day', 'month', 'year'].forEach(function (val, k) {
        append[val] = args && typeof args[val] != 'undefined' ? args[val] : true;
    });
    append.day && result.push(('0' + date.getDate()).slice(-2));
    append.month && result.push(('0' + (date.getMonth() + 1)).slice(-2));
    append.year && result.push(date.getFullYear());
    return result.join('-');
}

/*
 * JS tasks
 */
gulp.task('concat-libs-jq', function () {
    return gulp.src([
        '../webapp/js/lib/jquery-1.11.0.min.js',
        '../webapp/js/lib/jquery-ui.min.js',
        '../webapp/js/lib/modernizr.custom.27269.js',
        '../webapp/js/lib/underscore-min.js',
        '../webapp/js/lib/eluminate.js'
    ])
        .pipe(concat(pkg.name + '.jq.min.js'))
        .pipe(gulp.dest('../webapp/assets/js'));
});

gulp.task('concat-libs-bs', function () {
    return gulp.src([
        '../webapp/js/lib/bootstrap.min.js',
        '../webapp/js/lib/ui-bootstrap-tpls-0.12.1.min.js'
    ])
        .pipe(concat(pkg.name + '.bs.min.js'))
        .pipe(gulp.dest('../webapp/assets/js'));
});

gulp.task('concat-libs-angular', function () {
    return gulp.src([
        '../webapp/js/lib/angular.min.js',
        '../webapp/js/lib/ui-utils.min.js',
        '../webapp/js/lib/angular-animate.min.js',
        '../webapp/js/lib/angular-route.min.js',
        '../webapp/js/lib/angular-touch.min.js',
        '../webapp/js/lib/angular-sanitize.min.js',
        '../webapp/js/lib/bindonce.min.js',
        '../webapp/js/lib/angular-webstorage.min.js',
        '../webapp/js/lib/angular-md5.min.js',
        '../webapp/js/lib/angular-scroll.min.js'
    ])
        .pipe(concat(pkg.name + '.alib.min.js'))
        .pipe(gulp.dest('../webapp/assets/js'));
});

gulp.task('concat-libs-app', function () {
    return gulp.src([
        '../webapp/js/webapp.js',
        '../webapp/js/config/*.js',
        '../webapp/js/controllers/*.js',
        '../webapp/js/directives/*.js',
        '../webapp/js/services/*.js',
        '../webapp/js/interceptors/*.js'
    ])
        .pipe(concat(pkg.name + '.app.min.js'))
        .pipe(ngAnnotate({
            sourcemap: false
        }))
        //.pipe(uglify({
        //    options: {
        //        mangle: false,
        //        preserveComments: false
        //    }
        //}))
        .pipe(gulp.dest('../webapp/assets/js'));
});

gulp.task('minify-html', function () {
    var opts = {
        empty: true,
        conditionals: true,
        spare: true,
        quotes: true
    };

    return gulp.src('../webapp/templates/*.html')
        .pipe(minifyHTML(opts))
        .pipe(gulp.dest('../webapp/assets/templates'));
});

gulp.task('concat-libs', ['concat-libs-jq', 'concat-libs-bs', 'concat-libs-angular', 'concat-libs-app']);

/*
 * CSS tasks
 */
gulp.task('cssmin', function () {
    var dest = '../webapp/css/';
    return merge(
        gulp.src([
            '../webapp/css/style.css',
            '../webapp/css/print.css'
        ])
            .pipe(sass({outputStyle: 'compressed'}))
    ).pipe(rename({
            suffix: '.min',
            extname: '.css'
        }))
        .pipe(gulp.dest(dest))
});


gulp.task('default', ['concat-libs', 'cssmin', 'minify-html']);