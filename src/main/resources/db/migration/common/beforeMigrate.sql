update users set user_name = upper(user_name)
where user_name != upper(user_name);