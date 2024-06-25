import {Datagrid, EditButton, List, TextField} from 'react-admin'

export const MovieList = () => (
	<List>
		<Datagrid rowClick='show'>
			<TextField source='id' />
			<TextField source='title' />
			<TextField source='release_year' />
			<TextField source='director' />
			<TextField source='rating' />
			<TextField source='description' />
			<TextField source='category_id' />
			<TextField source='category_name' />
			<EditButton label='Edit' />
		</Datagrid>
	</List>
)
