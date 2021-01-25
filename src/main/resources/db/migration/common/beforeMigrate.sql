/**
* This is an example of sql callback that runs before any kind of migration.
* Note: Commenting because this fails if the table does not exists.
 */
--update users set user_name = upper(user_name)
--where user_name != upper(user_name);