INSERT INTO users (username, password, roles)
VALUES
    ('admin', '$2a$10$CrE6gSeUAQtqAclAE2EBJOxeYPW3snw...xq5m/kq8wRL2EqNI3xW', 'ADMIN');

INSERT INTO movies (name, genre, rating, cover_photo, background, trailer_url, video_url)
VALUES
    ('Die Hard', 'Action', 0, '/images/coverphotos/diehard.jpg', '/images/backgrounds/diehard.jpg', 'https://www.youtube.com/watch?v=gYWvwkXreaI', '/video/example.mp4'),
    ('Die Hard 2', 'Action', 0, '/images/coverphotos/diehard2.jpg', '/images/backgrounds/diehard2.jpg', 'https://www.youtube.com/watch?v=CvHp7xJZ4_U', '/video/example.mp4'),
    ('Die Hard 3', 'Action', 0, '/images/coverphotos/diehard3.jpg', '/images/backgrounds/diehard3.jpg', 'https://www.youtube.com/watch?v=i5asAs5HQkQ', '/video/example.mp4'),
    ('Die Hard 4', 'Action', 0, '/images/coverphotos/diehard4.jpg', '/images/backgrounds/diehard4.jpg', 'https://www.youtube.com/watch?v=xqjICXgcsZM', '/video/example.mp4'),
    ('Rambo 1', 'Action', 0, '/images/coverphotos/rambo.jpg', '/images/backgrounds/rambo.jpg', 'https://www.youtube.com/watch?v=IAqLKlxY3Eo', '/video/example.mp4'),
    ('Rambo 2', 'Action', 0, '/images/coverphotos/rambo2.jpg', '/images/backgrounds/rambo2.jpg', 'https://www.youtube.com/watch?v=jtPNhGWxY4g', '/video/example.mp4'),
    ('Rambo 3', 'Action', 0, '/images/coverphotos/rambo3.jpg', '/images/backgrounds/rambo3.jpg', 'https://www.youtube.com/watch?v=IQt9bDOGTgg', '/video/example.mp4'),
    ('Rambo 4', 'Action', 0, '/images/coverphotos/rambo4.jpg', '/images/backgrounds/rambo4.jpg', 'https://www.youtube.com/watch?v=2CRjdwRYQbU', '/video/example.mp4'),
    ('Rocky 1', 'Action', 0, '/images/coverphotos/rocky.jpg', '/images/backgrounds/rocky.jpg', 'https://www.youtube.com/watch?v=-Hk-LYcavrw', '/video/example.mp4'),
    ('Rocky 2', 'Action', 0, '/images/coverphotos/rocky2.jpg', '/images/backgrounds/rocky2.jpg', 'https://www.youtube.com/watch?v=A2P9ATb9Qx8', '/video/example.mp4'),
    ('Rocky 3', 'Action', 0, '/images/coverphotos/rocky3.jpg', '/images/backgrounds/rocky3.jpg', 'https://www.youtube.com/watch?v=o7vbDPUMWDc', '/video/example.mp4'),
    ('Rocky 4', 'Action', 0, '/images/coverphotos/rocky4.jpg', '/images/backgrounds/rocky4.jpg', 'https://www.youtube.com/watch?v=4qjV0bB2V0Q', '/video/example.mp4'),
    ('Deadpool & Wolverine', 'Action', 0, '/images/coverphotos/deadpoolandwolverine.jpg', '/images/backgrounds/deadpoolandwolverine.jpg', 'https://www.youtube.com/watch?v=73_1biulkYk', '/video/example.mp4');

INSERT INTO tvshows (name, genre, rating, cover_photo, background, trailer_url, video_url)
VALUES
    ('Tulsa King', 'Crime', 0, '/images/coverphotos/tvshows/tulsaking.jpg', '/images/backgrounds/tvshows/tulsaking.jpg', 'https://www.youtube.com/watch?v=aaQSScwZPbA', '/video/example.mp4'),
    ('White Collar', 'Crime', 0, '/images/coverphotos/tvshows/whitecollar.jpg', '/images/backgrounds/tvshows/whitecollar.jpg', 'https://www.youtube.com/watch?v=c5iVTy-GuJ0', '/video/example.mp4'),
    ('Foundation', 'Sci-Fi', 0, '/images/coverphotos/tvshows/foundation.jpg', '/images/backgrounds/tvshows/foundation.jpg', 'https://www.youtube.com/watch?v=X4QYV5GTz7c', '/video/example.mp4'),
    ('Squid Game', 'Drama', 0, '/images/coverphotos/tvshows/squidgame.jpg', '/images/backgrounds/tvshows/squidgame.jpg', 'https://www.youtube.com/watch?v=oqxAJKy0ii4', '/video/example.mp4'),
    ('The Peripheral', 'Mystery', 0, '/images/coverphotos/tvshows/theperipheral.jpg', '/images/backgrounds/tvshows/theperipheral.jpg', 'https://www.youtube.com/watch?v=BqqShroJH44', '/video/example.mp4'),
    ('Bel-Air', 'Drama', 0, '/images/coverphotos/tvshows/belair.jpg', '/images/backgrounds/tvshows/belair.jpg', 'https://www.youtube.com/watch?v=rQ1uG91Bbls', '/video/example.mp4'),
    ('Friends', 'Comedy', 0, '/images/coverphotos/tvshows/friends.jpg', '/images/backgrounds/tvshows/friends.jpg', 'https://www.youtube.com/watch?v=RjpvuPAzJUw', '/video/example.mp4'),
    ('Dexter', 'Crime', 0, '/images/coverphotos/tvshows/dexter.jpg', '/images/backgrounds/tvshows/dexter.jpg', 'https://www.youtube.com/watch?v=YQeUmSD1c3g', '/video/example.mp4'),
    ('Power', 'Crime', 0, '/images/coverphotos/tvshows/power.jpg', '/images/backgrounds/tvshows/power.jpg', 'https://www.youtube.com/watch?v=g9PBhyTHhRE', '/video/example.mp4'),
    ('Its Always Sunny In Philadelphia', 'Comedy', 0, '/images/coverphotos/tvshows/itsalwayssunnyinphiladelphia.jpg', '/images/backgrounds/tvshows/itsalwayssunnyinphiladelphia.jpg', 'https://www.youtube.com/watch?v=2gcEbzGbp38', '/video/example.mp4'),
    ('Community', 'Comedy', 0, '/images/coverphotos/tvshows/community.jpg', '/images/backgrounds/tvshows/community.jpg', 'https://www.youtube.com/watch?v=ZfmcHfKHU_Q', '/video/example.mp4'),
    ('How I Met Your Mother', 'Comedy', 0, '/images/coverphotos/tvshows/himym.jpg', '/images/backgrounds/tvshows/himym.jpg', 'https://www.youtube.com/watch?v=aDGI-Tpjm0U', '/video/example.mp4'),
    ('Psych', 'Comedy', 0, '/images/coverphotos/tvshows/psych.jpg', '/images/backgrounds/tvshows/psych.jpg', 'https://www.youtube.com/watch?v=z4jSE0D69Kw', '/video/example.mp4'),
    ('Entourage', 'Comedy', 0, '/images/coverphotos/tvshows/entourage.jpg', '/images/backgrounds/tvshows/entourage.jpg', 'https://www.youtube.com/watch?v=UZ85zOeAGYs', '/video/example.mp4');