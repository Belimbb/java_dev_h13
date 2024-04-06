-- add clients --
insert into public.client (name)
values
        ('Nazar'),
        ('Maksim'),
        ('Zhenya'),
        ('Vitalina'),
        ('Dasha'),
        ('Natasha'),
        ('Aleksey'),
        ('Igor'),
        ('Kiril'),
        ('Pavlik');

-- add planets --
insert into planet (id, name)
values
        ('VEN', 'Venus'),
        ('M3RC', 'Mercury'),
        ('EARTH2', 'Space earth'),
        ('PLU', 'Plutonium'),
        ('SAT', 'Saturn');

-- add tickets --
insert into ticket (created_at, client_id, from_planet_id)
values
        ('2024-03-28 12:34:56', 1, 'VEN'),
        ('2024-04-01 13:00:00', 2, 'VEN'),
        ('2024-04-04 14:15:30', 3, 'M3RC'),
        ('2024-04-07 16:45:00', 4, 'M3RC'),
        ('2024-04-10 18:30:00', 5, 'EARTH2'),
        ('2024-04-13 19:05:45', 6, 'EARTH2'),
        ('2024-04-16 20:20:20', 7, 'PLU'),
        ('2024-04-19 21:55:55', 8, 'PLU'),
        ('2024-04-22 22:22:22', 9, 'SAT'),
        ('2024-04-25 23:33:33', 10, 'SAT');